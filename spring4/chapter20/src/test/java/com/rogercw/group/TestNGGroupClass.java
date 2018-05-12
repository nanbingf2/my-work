package com.rogercw.group;

import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/11.
 */

@Test(groups = "groupc")  //设置用例级分组
public class TestNGGroupClass {

    @Test
    public void method1OfC() {
        System.out.println("method1OfC");
    }

    @Test
    public void method2OfC() {
        System.out.println("method2OfC");
    }
}
