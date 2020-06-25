package com.jeff.jdbc.service;

import com.jeff.jdbc.bean.User;
import org.junit.Test;

import java.sql.*;

public class LoginServiceNew {

    @Test
    public User findUserByNameAndPassord(String name, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");
            String sql = "select uid,username,password from t_user where username =? and password =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

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
                if (preparedStatement != null) {
                    preparedStatement.close();
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
