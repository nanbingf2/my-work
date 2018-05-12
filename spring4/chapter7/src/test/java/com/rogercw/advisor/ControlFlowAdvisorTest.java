package com.rogercw.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/1.
 */
public class ControlFlowAdvisorTest {

    @Test
    public void controlFlowAdviceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com.rogercw.advisor/application.xml");
        Waiter waiter = (Waiter) context.getBean("waiterProxy");
        WaiterDelegate waiterDelegate=new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiterDelegate.server("李四");
        waiter.greet("zhangsan");
        waiter.server("lisi");
    }
}
