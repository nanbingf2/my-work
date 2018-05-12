package com.rogercw.paramtertest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/11.
 */
public class CharASCIITest {

    @DataProvider(name="data")
    public Object[][] getParamters(){
        return new Object[][]{
                { 'A', 65 },{ 'a', 97 },
                { 'B', 66 },{ 'b', 98 },
                { 'C', 67 },{ 'c', 99 },
                { 'D', 68 },{ 'd', 100 },
                { 'Z', 90 },{ 'z', 122 },
                { '1', 49 },{ '9', 57 }
        };
    }

    @Test(dataProvider = "data")
    public void charASCIITest(char character,int ascii) {
        Assert.assertTrue(ascii==CharUtils.charToASCII(character));
    }
}
