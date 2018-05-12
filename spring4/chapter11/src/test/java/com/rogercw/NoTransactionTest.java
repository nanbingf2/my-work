package com.rogercw;

import com.rogercw.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/5.
 */
public class NoTransactionTest {

    @Test
    public void noTransactioTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:notransaction/application.xml");
        AccountService service = (AccountService) context.getBean("noTransactionService");
        service.transfer("zhangsan","lisi",100);
    }
}
