package com.jeff.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_Test01 {

    public static void main(String[] args) throws Exception {
        // 註冊驅動
        Class.forName("com.mysql.jdbc.Driver");
        // 獲取連接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");
        // 得到執行sql語句的對象statement
        Statement stmt = conn.createStatement();
        // 執行sql語句，並返回結果
        ResultSet rs = stmt.executeQuery("select uid,username,password,address from t_user");
        // 處理結果
        while(rs.next()){
            System.out.println(rs.getObject("uid"));
            System.out.println(rs.getObject("username"));
            System.out.println(rs.getObject("password"));
            System.out.println(rs.getObject("address"));
            System.out.println("==========================");
        }
        // 關閉Connection
        rs.close();
        stmt.close();
        conn.close();
    }


}
