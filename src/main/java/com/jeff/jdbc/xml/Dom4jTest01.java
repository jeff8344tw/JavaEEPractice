package com.jeff.jdbc.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest01 {

    /**
     * 得到某個具體的節點內容
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        // 創降一個xml解析對象
        SAXReader reader = new SAXReader();
        // 把xml文黨加載到document對象中
        Document document = reader.read("src/main/resources/test.xml");
        // 獲取根節點
        Element root = document.getRootElement();
        // 獲取當前節點的所有子節點
        List list = root.elements();
        Element element = (Element) list.get(0);
        String name = element.element("name").getText();
        System.out.println(name);
    }

    /**
     * 遍歷所有元素節點
     */
    @Test
    public void test2() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/main/resources/test.xml");
        Element root = document.getRootElement();
        treeSelect(root);
    }

    private void treeSelect(Element element) {
        // 獲取當前節點的名字
        System.out.println(element.getName());
        for (int i = 0; i < element.nodeCount(); i++) {
            // 取出下標為i的節點
            Node node = element.node(i);
            // 判斷當前節點是否為標籤
            if (node instanceof Element) {
                treeSelect((Element) node);
            } else {
                System.out.println(node.getText());
            }
        }
    }


}
