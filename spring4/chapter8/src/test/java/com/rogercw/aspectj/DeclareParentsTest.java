package com.rogercw.aspectj;

import com.rogercw.Seller;
import com.rogercw.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/5.
 */
public class DeclareParentsTest {

    @Test
    public void declareParentsTest() {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:aspectj/application.xml");
        Waiter waiter = context.getBean(Waiter.class);
        waiter.greet("zhangsan");
        Seller seller=(Seller)waiter;
        seller.seller("beer");

    }
}
