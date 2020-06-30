package com.jeff.servlet.http;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用戶登陸
 */
public class doLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        // 獲取表單數據
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        // 判斷用戶是否輸入正確的用戶名和密碼
        if(userName.equals("admin") && password.equals("123456")){
            writer.write("登入成功");
            // 用戶勾選了十天內自動登入
            if(remember != null) {
                Cookie cookie1 = new Cookie("username", userName);
                Cookie cookie2 = new Cookie("password", password);
                // 設置cookie失效時間為十天
                cookie1.setMaxAge(60 * 60 * 240);
                cookie2.setMaxAge(60 * 60 * 240);
                // 設cookie的綁定路徑
                cookie1.setPath("/");
                cookie2.setPath("/");
                // 將cookie發送給客戶端
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
        }else {
            writer.write("登入失敗");
            // 設置2秒後跳轉到登入頁面
            resp.setHeader("refresh","2;url="+req.getContextPath() + "/loginServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
