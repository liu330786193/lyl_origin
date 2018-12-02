package com.lyl.context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.lyl.annotation.ResponseWithoutResult;
import com.lyl.ensure.Ensure;
import com.lyl.exception.CExceptionFactory;
import com.lyl.util.MapUtils;
import com.lyl.util.SignType;
import com.lyl.util.StringUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpMethod;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

/**
 * Created by lyl on 2016/9/11.
 */
public class CContext {

    protected static final ThreadLocal<CContext> THREAD_LOCAL = new ThreadLocal<CContext>() {
        @Override
        protected CContext initialValue() {
            return new CContext();
        }
    };

    protected HttpServletRequest request;
    private JSONObject postJsonBody;
    private String postJsonBodyStr;
    private Map<String, String> requestParamMap;
    private boolean skipCheckSignature = false;
    private long requestStartTime;

    private boolean isInited = false;
    private Object handler;
    private boolean isSigned = false;

    protected CContext() {

    }

    /**
     * 创建context
     *
     * @return
     */
    public static CContext createContext() {
        CContext xContext = new CContext();
        THREAD_LOCAL.set(xContext);

        return xContext;
    }

    /**
     * 获取当前Context
     *
     * @return
     */
    public static CContext getCurrentContext() {
        return THREAD_LOCAL.get();
    }


    /**
     * 在Interceptor中使用，初始化参数
     */
    public void init(HttpServletRequest request, Object handler) {
        this.request = request;
        System.out.println("this.request:" + this.request);
        System.out.println("request:" + request);
        this.setRequestStartTime(System.currentTimeMillis());
        this.isInited = true;
        this.handler = handler;
        if (isPostRequest()) {
            this.postJsonBody = parse(this.request);
        }
    }

    /**
     * 获取请求对应的URL
     */
    public String getServiceUrl() {
        String queryString = request.getQueryString();
        if(StringUtils.isNotEmpty(queryString)) {
            return request.getRequestURI() + "?" + queryString;
        } else {
            return request.getRequestURI();
        }
    }

    /**
     * 获取Request中所有参数的HashCode
     *
     * @return HashCode
     */
    public int getRequestHashCode() {
        return request.hashCode();
    }

    /**
     * 将参数序列化成字符串
     *
     * @return
     */
    public String getParamsString() {
        Map<String, String> paramMap = getParameterMap();
        if (CollectionUtils.isEmpty(paramMap)) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hashcode=").append(getRequestHashCode());
        for (Map.Entry<String,String> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            /** 过滤upYun开头的参数 */
            if(key.startsWith("upYun")){
                continue;
            }
            if (key.contains("password")) {
                stringBuilder.append(',').append(key).append('=').append("******");
            } else {
                stringBuilder.append(',').append(key).append('=').append(entry.getValue());
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 获取参数列表
     *
     * @return
     */
    public Map<String, String> getParameterMap() {
        if (requestParamMap == null) {
            if (isPostRequest()) {
                if(postJsonBody == null ){
                    return  Collections.emptyMap();
                }
                return MapUtils.convertValueToString(this.postJsonBody);
            } else {
                requestParamMap = MapUtils.convertValueToString(request.getParameterMap());
            }
        }
        return requestParamMap;

    }

    /**
     * 获取来源的相关信息，格式如下：[shopId]
     *
     * @return 来源的相关信息（默认为门店信息）
     */
    public String getSource() {
        String shopId = isPostRequest() ? this.postJsonBody.getString("shopId") : request.getParameter("shopId");
        return "shopId=" + shopId;
    }

    public long getRequestStartTime() {
        return requestStartTime;
    }

    public void setRequestStartTime(long requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    /**
     * 获取参数
     *
     * @return
     */
    public String getParameter(String key) {
        return getParameterMap().get(key);
    }

    /**
     * Method 为POST时候以JSON方式传递参数
     *
     * @return
     */
    public String getPostJsonBodyStr() {
        if (StringUtils.isEmpty(postJsonBodyStr)) {
            postJsonBodyStr = "{}";
        }

        return postJsonBodyStr;
    }

    /**
     * 判断请求类型是否为Post
     *
     * @return 是否为Post请求
     */
    public boolean isPostRequest() {
        if (request == null) {
            throw CExceptionFactory.create("F_WEBKITS_COMMON_1006");
        }
        if (StringUtils.isNotEmpty(request.getHeader("Access-Control-Request-Method")) && ((String)request.getHeader("Access-Control-Request-Method")).equals(HttpMethod.POST.name())){
            return true;
        }
        boolean isPost = request.getMethod().equals(HttpMethod.POST.name()) || request.getMethod().equals(HttpMethod.PUT.name());
        return isPost && isJsonRequest();
    }

    /**
     * 判断请求类型是否为Json
     *
     * @return 是否为Json请求
     */
    public boolean isJsonRequest(){
        if (request == null) {
            throw CExceptionFactory.create("F_WEBKITS_COMMON_1006");
        }

        String contentType = request.getContentType();
        if (contentType.contains("application/json") || contentType.contains("text/json")){
            return true;
        }
        return false;
    }

    public boolean isOpenApiRequest(){
        return getServiceUrl().indexOf("/api") == 0;
    }

    /**
     * 将request中inputStream 解析为JSONObject
     *
     * @param request
     * @return 解析RequestBody中的Json字符串
     */
    private JSONObject parse(HttpServletRequest request) {
        try {
            ServletInputStream servletInputStream = request.getInputStream();
            postJsonBodyStr = IOUtils.toString(request.getInputStream(), "UTF-8");
            //subString 去掉"data="前缀
            if (postJsonBodyStr.contains("{\"data\":")) {
                postJsonBodyStr = (String) JSON.parseObject(postJsonBodyStr).get("data");
                return JSON.parseObject(postJsonBodyStr, Feature.SupportArrayToBean);
            }
            return JSON.parseObject(postJsonBodyStr, Feature.SupportArrayToBean);
        } catch (Exception ex) {
            throw CExceptionFactory.create("F_WEBKITS_COMMON_1007", request.getRequestURI(), postJsonBodyStr, ex.getMessage());
        }
    }

    public SignType getSignType(){
        String signTypeStr = request.getHeader("signType");
        Ensure.that(SignType.isSignType(signTypeStr)).isTrue("F_WEBKITS_SIGN_1007");
        return SignType.valueOf(signTypeStr);
    }

    //主要是为了解决老框架中，区分ajax与OpenApi接口
    public boolean isInited() {
        return isInited;
    }

    public boolean isSkipCheckSignature() {
        return skipCheckSignature;
    }

    public void setSkipCheckSignature(boolean skipCheckSignature) {
        this.skipCheckSignature = skipCheckSignature;
    }

    public boolean isResponseWithoutResult(){
        if(handler == null){
            return false;
        }
        ResponseWithoutResult responseWithoutResult = ((HandlerMethod) handler).getMethodAnnotation(ResponseWithoutResult.class);

        if(responseWithoutResult == null){
            return false;
        }
        return true;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    /**
     * 清理当前线程中的数据
     */
    public void clear() {
        request = null;
        postJsonBody = null;
        postJsonBodyStr = null;
        requestParamMap = null;
        isInited = false;
        requestStartTime = 0;
        isSigned = false;
    }

    public static void clearCurrentContext() {
        CContext context = getCurrentContext();
        if(context != null){
            context.clear();
        }
        THREAD_LOCAL.remove();
    }
}
