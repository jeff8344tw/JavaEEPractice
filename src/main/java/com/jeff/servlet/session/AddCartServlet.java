package com.jeff.servlet.session;

import com.jeff.servlet.bean.Book;
import com.jeff.servlet.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 向購物車添加書籍
 */
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        
        // 取得圖書的id
        Integer id = Integer.parseInt(req.getParameter("id"));

        // 獲取session對象
        HttpSession session = req.getSession();

        Map<Integer, Integer> map = (Map<Integer, Integer>) session.getAttribute("ShoppingCard");

        // 說明session是空，即第一次向session中存放數據
        if(map == null) {
            map = new HashMap<>();
        }

        if(!map.containsKey(id)) {
            map.put(id, 1);
        }else {
            map.put(id,map.get(id) + 1);
        }

        session.setAttribute("ShoppingCart", map);
        writer.write("購物車添加成功");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
