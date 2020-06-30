package com.jeff.servlet.http;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie的默認綁定路徑
 */
public class CookieTest01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 創建Cookie對象，第一個參數類似map中的key，第二個參數類似map的value，不要直接存中文
        Cookie cookie1 = new Cookie("username", "admin");
        Cookie cookie2 = new Cookie("password", "123456");

        // 手動設置綁定路徑
        cookie1.setPath(req.getContextPath() +"/aaa");
        cookie2.setPath(req.getContextPath() +"/aaa");

        // 設置cookie的失效時間，參數的單位是秒
        // 大於0:則表示要將Cookie寫入到硬盤文件中
        // 小於0:則表示Cookie存放在瀏覽器緩存中，與不設置時常等效
        // 等於0:則表示Cookie產生後直接失效
        cookie1.setMaxAge(60 * 60); // 一小時
        cookie1.setMaxAge(60 * 60 * 24); // 一天

        // 將cookie對象添加到響應中
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
