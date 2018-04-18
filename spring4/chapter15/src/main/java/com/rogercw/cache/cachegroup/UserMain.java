package com.rogercw.cache.cachegroup;

import com.rogercw.cache.domain.Member;
import com.rogercw.cache.domain.User;
import com.rogercw.cache.domain.Visitor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 1 on 2018/4/18.
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserService userService= (UserService) context.getBean("cacheGroupUserService");

        User member=new Member("1","zhangsan",18);
        User visitor=new Visitor("2","lisi",21);

        User user1 = userService.getUser(member);
        System.out.println(user1);

        User user2=userService.getUser(visitor);
        System.out.println(user2);

        //获取缓存管理器对象
        CacheManager cacheManager= (CacheManager) context.getBean("cacheManager");
        Cache memberCache = cacheManager.getCache("member");
        System.out.println("member缓存里的缓存数据为:"+
                ((ConcurrentHashMap)memberCache.getNativeCache()).values());

        Cache visitCache=cacheManager.getCache("visitor");
        System.out.println("visitor缓存了的缓存数据为:"+
                ((ConcurrentHashMap)visitCache.getNativeCache()).values());
    }
}
