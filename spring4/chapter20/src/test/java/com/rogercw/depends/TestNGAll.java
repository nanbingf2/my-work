package com.rogercw.depends;

import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/11.
 */
public class TestNGAll {

    @Test(dependsOnGroups = {"groupA","groupB"})
    public void method5() {
        System.out.println("method5");
    }

    @Test(dependsOnMethods = "method5")
    public void method6() {
        System.out.println("method6");
    }
}
