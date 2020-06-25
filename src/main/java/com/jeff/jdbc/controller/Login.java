package com.jeff.jdbc.controller;

import com.jeff.jdbc.bean.User;
import com.jeff.jdbc.service.LoginService;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("請輸入用戶名:");
        String name = input.nextLine();
        System.out.println("請輸入密碼:");
        String password = input.nextLine();
        LoginService loginService = new LoginService();
        User user = loginService.findUserByNameAndPassord(name, password);
        if(user == null) {
            System.out.println("用戶名或密碼錯誤");
        }else{
            System.out.println("登入成功!");
        }
    }
}
