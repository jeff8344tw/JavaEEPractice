package com.jeff.servlet.http;

import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用HttpServiceResponse向客戶端發送響應數據
 */
public class ResponseTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");

        // 解決響應亂碼方式1
        // 設置字符編碼為urf-8
        resp.setCharacterEncoding("UTF-8");
        // 告訴瀏覽器以uff-8的編碼方式解碼
        resp.addHeader("Content-type","text/html;charset=UTF-8");

        // 解決響應亂碼方式2 : 建議使用
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.print("用戶名: "+ username + "註冊成功!<br>");
        writer.println("感謝您的註冊");
 }
}
