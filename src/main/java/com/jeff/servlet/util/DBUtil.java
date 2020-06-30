package com.jeff.servlet.util;

import com.jeff.servlet.bean.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品數據初始化
 */
public class DBUtil {

    private static Map<Integer, Book> books = new HashMap<>();

    // 商品數據的初始化
    static {
        books.put(1, new Book(1,"name1",20,"jeff1"));
        books.put(2, new Book(2,"name2",30,"jeff2"));
        books.put(3, new Book(3,"name3",40,"jeff3"));
        books.put(4, new Book(4,"name4",50,"jeff4"));
    }
    /**
     * 取得全部圖書
     */
    public static Map<Integer, Book> findAllBooks() {
        return books;
    }

    public static Book findBookById(Integer id) {
        return books.get(id);
    }
}
