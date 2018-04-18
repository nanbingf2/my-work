package com.rogercw.cache.simplecache;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 1 on 2018/4/16.
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) context.getBean("simpleCacheUserService");
        //第一次查询,从真实数据来源查询
        System.out.println("第一次查询....应该从真实数据来源处查询数据");
        userService.getUserById("0002");
        System.out.println("第二次查询.....应该从缓存中查询");
        userService.getUserById("0002");
    }
}
