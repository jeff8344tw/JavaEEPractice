package com.jeff.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet的生命週期
 */
public class LifeServlet implements Servlet {

    // 注意: 在servlet中不要定義可修改的成員變量，會有線程安全問題。
    private int count;

    public LifeServlet(){
        System.out.println("construct");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(++count);
        System.out.println("serve");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
