package com.rogercw.cache.cacheput;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 1 on 2018/4/17.
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserService userService= (UserService) context.getBean("cachePutUserservice");
        System.out.println("第一次查询,应该是从真实数据来源获取数据");
        userService.getUserById(1);
        System.out.println("第二次查询,应该从缓存中查询");
        userService.getUserById(1);
    }

}
