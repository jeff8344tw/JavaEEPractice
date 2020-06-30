package com.jeff.servlet.http;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 問題:
 *   實現獲取用戶上一次訪問時間的功能，及當用戶訪問服務氣，如果是非第一次訪問的話，
 *   需要將上一次訪問服務氣的時間給用戶顯示出來
 *
 * 分析:
 *   當用戶第一次訪問服務器時，將時間記錄下來並放到cookie中，用戶第二次訪問時，
 *   會將該cookie發送到服務器，服務器拿到後就可以獲取到上次訪問的時間了，
 *   將上次訪問的時間響應給瀏覽器並將新的訪問時間放到cookie中。
 */
public class LastVIsitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 防止亂碼
        resp.setContentType("text/html : charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        // 獲取客戶端所有的cookie
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(int i = 0; i < cookies.length ; i++){
                if(cookies[i].getName().equals("lastVisitTime")){
                    // 拿到上一次的訪問時間
                    long time = Long.parseLong(cookies[i].getValue());
                    writer.print("你的上次訪問時間是：" + new Date(time).toLocaleString()); // yyyy-MM-dd
                }
            }
        }

        // 創建cookie
        Cookie cookie = new Cookie("lastVisitTime", System.currentTimeMillis() + "");
        // 設置失效時間為1小時
        cookie.setMaxAge(60 * 60);
        // 將cookie訊息響應給客戶端
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
