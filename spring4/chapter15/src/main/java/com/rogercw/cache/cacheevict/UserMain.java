package com.rogercw.cache.cacheevict;

import com.rogercw.cache.domain.User;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 1 on 2018/4/18.
 */
public class UserMain {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserService userService= (UserService) context.getBean("cacheEvictUserService");

        User user1=userService.getUser(1);
        System.out.println(user1);

        User user2=userService.getUser(1);
        System.out.println(user2);

        userService.removeUser(1);
        User user3=userService.getUser(1);
        //用户1已经移除了,所以返回结果为null
        assertNull(user3);
    }
}
