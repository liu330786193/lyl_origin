package com.lyl.context;

/**
 * Created by nt on 2015-06-18.
 */
public class CWebContext extends CContext{

    private CWebContext(){

    }

    /**
     * 创建 WebContext
     * @return
     */
    public static CContext createXWebContext(){
        CWebContext cWebContext = new CWebContext();
        THREAD_LOCAL.set(cWebContext);
        return cWebContext;
    }

    @Override
    public String getSource() {
        return "webpath=" + this.request.getServletPath();
    }

}
