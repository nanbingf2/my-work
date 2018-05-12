package com.rogercw.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.sql.SQLException;

/**
 * Created by 1 on 2018/4/30.
 */
public class ThrowAdviceTest {
    /**
     * 抛出异常增强测试
     */
    @Test
    public void throwAdviceTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.rogercw.advice/application.xml");
        ForumService proxyService= (ForumService) context.getBean("proxyService");
        try {
            proxyService.createForum();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        proxyService.removeForum();
    }
}
