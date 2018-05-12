package com.rogercw;

import com.rogercw.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/5.
 */
public class TxTransactionTest {

    @Test
    public void txTransactionTest() {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:txtransaction/application.xml");
        AccountService service = (AccountService) context.getBean("txTransaction");
        service.transfer("lisi","zhangsan",100);
    }
}
