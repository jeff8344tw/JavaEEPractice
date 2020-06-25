package com.jeff.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class ConfigTest01 implements Servlet {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 獲取web.xml中配置的初始化參數
        String userName = servletConfig.getInitParameter("userName");
        System.out.println("userName = "+userName);

        Enumeration<String> params = servletConfig.getInitParameterNames();
        while(params.hasMoreElements()){
            String name = params.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println(name + " = " + value);
        }
        // 獲取servlet的名稱
        System.out.println(servletConfig.getServletName());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
