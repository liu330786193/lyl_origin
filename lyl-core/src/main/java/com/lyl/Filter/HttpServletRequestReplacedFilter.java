package com.lyl.Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by lyl on 2017/4/26.
 */
public class HttpServletRequestReplacedFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest requestWrapper = null;
        if (servletRequest instanceof HttpServletRequest){
            requestWrapper = new CacheHttpServletRequestWrapper((HttpServletRequest) servletRequest);
        }

        if (null == requestWrapper){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(requestWrapper, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

}
