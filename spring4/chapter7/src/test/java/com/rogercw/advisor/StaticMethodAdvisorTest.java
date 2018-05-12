package com.rogercw.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/1.
 */
public class StaticMethodAdvisorTest {

    @Test
    public void staticMethodAdvisor() {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:com.rogercw.advisor/application.xml");
        Waiter waiter= (Waiter) context.getBean("waiterProxy");
        Seller seller= (Seller) context.getBean("sellerProxy");
        waiter.greet("zhangsan");
        waiter.server("lisi");
        seller.greet("zhangsan");
    }
}
