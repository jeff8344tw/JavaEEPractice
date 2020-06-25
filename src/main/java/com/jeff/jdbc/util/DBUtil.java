package com.jeff.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBUtil {

    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;


    static {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        username = rb.getString("username");
        password = rb.getString("password");

        try {
            Class.forName(driverClass);
        }  catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }

    public static String getDriverClass() {
        return driverClass;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
