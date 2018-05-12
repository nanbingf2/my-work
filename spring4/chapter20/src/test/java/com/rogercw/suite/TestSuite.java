package com.rogercw.suite;

import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/11.
 */
public class TestSuite {

    @Test(groups = "suiteA")
    public void method1OfSuiteA(){
        System.out.println("method1OfSuiteA");
    }

    @Test(groups = "suiteA")
    public void method2OfSuiteA(){
        System.out.println("method1OfSuiteA");
    }

    @Test(groups = {"suiteA","suiteB"})
    public void method3OfSuiteAAndB(){
        System.out.println("method3OfSuiteAAndB");
    }

    @Test(groups = "suiteB")
    public void method4OfSuiteB() {
        System.out.println("method4OfSuiteB");
    }
}
