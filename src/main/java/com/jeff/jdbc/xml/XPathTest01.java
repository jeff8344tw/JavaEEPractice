package com.jeff.jdbc.xml;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * 使用XPath讀取xml
 */
public class XPathTest01 {

    @Test
    public void test01() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/main/resources/test.xml");
        Node node1 = document.selectSingleNode("/books/book/name");
        System.out.println(node1.getText());

        Node node2 = document.selectSingleNode("/books/book[2]/name");
        System.out.println(node2.getText());

        Node node3 = document.selectSingleNode("/books/book/attribute::id");
        System.out.println(node3.getText());

        Node node4 = document.selectSingleNode("/books/book[2]/attribute::id");
        System.out.println(node4);
    }

    @Test
    public void test2() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/main/resources/test.xml");
        List list = document.selectNodes("//*");
        for(int i = 0; i < list.size(); i++){
            Node node = (Node) list.get(i);
            System.out.println(node.getName() + "\t" + node.getText());
        }
    }

}
