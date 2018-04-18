package com.rogercw.cache.initcache;

import com.rogercw.cache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 1 on 2018/4/18.
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService= (UserService) context.getBean("initCacheUserService");

        User user1=new User("1","zhangsan",18);
        User user2=new User("2","lisi",20);
        //user1满足condition条件，因此会进行缓存
        User u11 = userService.getUser(user1);
        System.out.println(u11);
        //从缓存中查询数据
        User u12=userService.getUser(user1);
        System.out.println(u12);

        //user2不满足condition条件,因此不会进行缓存操作,
        User u21=userService.getUser(user2);
        System.out.println(u21);
        //两次都是调用真实的方法进行查询
        User u22=userService.getUser(user2);
        System.out.println(u22);

    }
}
