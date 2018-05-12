package com.rogercw.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/4/30.
 */
public class adviceTest {
    @Test
    public void adviceTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.rogercw.advice/application.xml");
        Waiter proxyWaiter= (Waiter) context.getBean("proxyWaiter");
        proxyWaiter.server("张三");

    }
}
