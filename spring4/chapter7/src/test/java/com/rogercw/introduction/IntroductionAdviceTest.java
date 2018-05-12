package com.rogercw.introduction;

import com.rogercw.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/1.
 * 引介增强测试
 */
public class IntroductionAdviceTest {

    @Test
    public void introductionTest() {
        ApplicationContext context=new ClassPathXmlApplicationContext("com.rogercw.introduction/application.xml");
        com.rogercw.advice.Waiter proxyWaiter= (Waiter) context.getBean("proxyWaiter");
        proxyWaiter.greet("张三");
        proxyWaiter.server("张三");

        Monitorable m= (Monitorable) proxyWaiter;
        m.setMonitorActive(true);
        proxyWaiter.greet("李四");
        proxyWaiter.server("李四");

    }

}
