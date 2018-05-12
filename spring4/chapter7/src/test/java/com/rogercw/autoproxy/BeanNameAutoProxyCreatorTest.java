package com.rogercw.autoproxy;

import com.rogercw.advisor.Seller;
import com.rogercw.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/3.
 */
public class BeanNameAutoProxyCreatorTest {

    @Test
    public void beanNameAutoProxyCreatorTest() {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:com.rogercw.autoproxy/application.xml");
        Waiter waiter = context.getBean(Waiter.class);
        Seller seller = context.getBean(Seller.class);
        waiter.greet("zhangsan");
        seller.greet("lisi");
    }


}
