package com.jeff.jdbc.service;

import com.jeff.jdbc.bean.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginService {

    @Test
    public User findUserByNameAndPassord(String name, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select uid,username,password from t_user where username = \''" + name + "\' and password = \'" + password +"\''");

            while(resultSet.next()){
                user.setUid(resultSet.getInt("uid"));
                user.setUsername(resultSet.getString("username"));
                user.setAddress(resultSet.getString("password"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return user;
    }
}
