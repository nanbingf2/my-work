package com.rogercw;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by 1 on 2018/5/11.
 */
public class TestNGAnno {

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @Test
    public void testAnno1() {
        Assert.assertTrue(true);
        System.out.println("testAnno1");
    }

    @Test
    public void testAnno2() {
        Assert.assertTrue(true);
        System.out.println("testAnno2");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
}
