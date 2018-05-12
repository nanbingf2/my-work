package com.rogercw.fun;

import com.rogercw.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/5.
 */
public class FunTest {

    @Test
    public void funTest() {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:fun/application.xml");
        Waiter naviWaiter= (Waiter) context.getBean("naviWaiter");
        Waiter funWaiter= (Waiter) context.getBean("funWaiter");
        naviWaiter.greet("zhangsan");
        funWaiter.greet("lisi");
    }
}
