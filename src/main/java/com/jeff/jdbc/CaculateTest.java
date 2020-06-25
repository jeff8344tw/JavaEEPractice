package com.jeff.jdbc;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CaculateTest {

    @Test
    public void test01(){
        System.out.println("test");
    }

    @Test
    public void test02(){
        Caculate caculate = new Caculate();
        Assert.assertEquals(15, caculate.add(5,10));
        TestCase.assertEquals(10, caculate.add(5, 10));
    }

    @Test
    public void test03(){
        Caculate caculate = new Caculate();
        Assert.assertEquals(3, caculate.div(10,3), 0.4);
    }


}

class Caculate {
    public int add(int a, int b){
        return a + b;
    }

    public double div(double a, double b){
        return a / b;
    }
}

