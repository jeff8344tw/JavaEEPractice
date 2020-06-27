package com.jeff.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ContextTest02 implements Servlet {

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
        ServletContext application = this.servletConfig.getServletContext();

        System.out.println("ContextTest02中的application:"+application);

        String admin = (String) application.getAttribute("admint");
        System.out.println(admin);
        String password = (String) application.getAttribute("password");
        System.out.println(admin);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {


    }
}
