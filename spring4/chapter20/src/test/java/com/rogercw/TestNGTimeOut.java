package com.rogercw;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/11.
 * 超时测试
 */
public class TestNGTimeOut {

    @Test(timeOut = 1000)
    public void testTimeOut1() {
        System.out.println("****testTimeOut1****");
        Assert.assertTrue(true);
    }

    @Test(timeOut = 3000)
    public void testTimeOut2() {
        System.out.println("****testTimeOut2****");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(true);
    }
}
