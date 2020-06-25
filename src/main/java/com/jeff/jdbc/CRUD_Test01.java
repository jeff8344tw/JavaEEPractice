package com.jeff.jdbc;

import com.jeff.jdbc.bean.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Test01 {

    @Test
    public void testInsert() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");

        Statement statement = connection.createStatement();

        int flag = statement.executeUpdate("insert into t_user(username,password,address) values('jjj','123','456')");

        if(flag > 0){
            System.out.println("success");
        }

        statement.close();
        connection.close();
    }

    @Test
    public void testUpdate() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");

        Statement statement = connection.createStatement();

        int flag = statement.executeUpdate("update t_user set password='555' where uid = 1");

        if(flag > 0){
            System.out.println("success");
        }

        statement.close();
        connection.close();
    }

    @Test
    public void testDelete() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");

        Statement statement = connection.createStatement();

        int flag = statement.executeUpdate("delete from t_user where username='jjj'");

        if(flag > 0){
            System.out.println("success");
        }

        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() throws Exception {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            // 註冊驅動
            Class.forName("com.mysql.jdbc.Driver");
            // 獲取連接Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");
            // 得到執行sql語句的對象statement
            stmt = conn.createStatement();
            // 執行sql語句，並返回結果
            rs = stmt.executeQuery("select uid,username,password,address from t_user");

            List<User> userList = new ArrayList<>();
            // 處理結果
            while(rs.next()){
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setAddress(rs.getString("password"));
                userList.add(user);
            }
            System.out.println(userList);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 關閉Connection
            if(rs != null) {
                rs.close();
            }
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
    }
}
