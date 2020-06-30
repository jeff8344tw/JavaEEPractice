package com.jeff.servlet.session;

import com.jeff.servlet.bean.Book;
import com.jeff.servlet.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ShowBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("全部書籍:<br>");

        Map<Integer, Book> books = DBUtil.findAllBooks();
        
        // 生成html
        for(Map.Entry<Integer, Book> book : books.entrySet()) {
            writer.write("<a href=addCartServlet?id=" + book.getKey() + ">" + book.getValue().getName()+"</a><br>");
        }
        writer.write("<a href='showCartServlet'>查看購物車</a><br>");
        writer.write("<a href='clearBookServlet'>清空購物車</a>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
