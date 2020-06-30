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
 * 查看購物車
 */
public class ShowCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("您的購物車中有以下商品:<br>");

        HttpSession session = req.getSession();
        Map<Integer,Integer> books = (Map<Integer, Integer>) session.getAttribute("ShoppingCart");

        if(books == null) {
            writer.write("購物車為空");
            resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/showBookServlet");
        }else {
            for(Map.Entry<Integer, Integer> entry : books.entrySet()) {
                Book book = new Book();
                book = DBUtil.findBookById(entry.getKey());
                writer.write("name: " + book.getName() + " count:" + entry.getValue() + "<br>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
