package com.lyl.context;

/**
 * Created by nt on 2015-06-18.
 */
public class CGeneralContext extends CContext {

    private CGeneralContext(){

    }

    /**
     * 创建 GeneralContext
     * @return
     */
    public static CContext createXGeneralContext(){
        CGeneralContext xGeneralContext = new CGeneralContext();
        THREAD_LOCAL.set(xGeneralContext);
        return xGeneralContext;
    }

    @Override
    public String getSource() {
        return "clientId=" + this.getParameter("clientId");
    }

}
