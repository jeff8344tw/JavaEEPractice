package com.jeff.jdbc;

import com.jeff.jdbc.bean.User;
import com.jeff.jdbc.util.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Test02 {

    @Test
    public void testSelect() {

        try(Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select uid,username,password,address from t_user")){
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
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
