package com.jeff.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ContextTest01 implements Servlet {

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
        System.out.println("ContextTest01中的application:"+application);
        // 獲取應用的初始化數據
        String driver = application.getInitParameter("MYSQLDriver");
        System.out.println(driver);

        String contextPath = application.getContextPath();
        System.out.println("contextPath: "+contextPath);

        // 獲取文件在硬盤的絕對路徑
        String realPath = application.getRealPath("FirstServlet");
        System.out.println("real path = " + realPath);

        // 向ServletContext中添加屬性
        application.setAttribute("admin", "tiger");
        application.setAttribute("password", 123456);
        application.removeAttribute("password");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {


    }
}
