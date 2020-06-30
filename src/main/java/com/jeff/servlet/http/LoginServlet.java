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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String userName = "";
        String password = "";

        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("username")) {
                    userName = cookie.getValue();
                }
                if(cookie.getName().equals("password")){
                    password = cookie.getValue();
                }
            }
        }

        PrintWriter writer = resp.getWriter();

        if(userName.equals("admin") && password.equals("123456")){
            writer.write("登入成功");
        }else {
            writer.write("<html><head></head><body>");
            writer.write("<form action='doLoginServlet'>");
            writer.write("用戶名: <input name='username' type='text'>");
            writer.write("<br>");
            writer.write("密碼: <input name='password' type='password'>");
            writer.write("<br>");
            writer.write("<input type='checkbox' name='remember'>十天免登陸");
            writer.write("<br>");
            writer.write("<input type='submit' value='login'>");
            writer.write("</form></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
