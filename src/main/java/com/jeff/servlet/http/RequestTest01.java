package com.jeff.servlet.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用HttpServletRequest接收請求數據
 */
public class RequestTest01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 設置post請求的字符編碼，此方式只對post請求有效
        req.setCharacterEncoding("UTF-8");
        // 根據html中的name獲取用戶在input中編寫的value值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 獲取用戶勾選的checkbox的值
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("username = "+username);
        System.out.println("password = "+password);
        for(String s: hobby) {
            System.out.println(s);
        }

        String ip = req.getRemoteAddr();
        System.out.println(ip);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
