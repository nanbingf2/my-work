package com.rogercw.cache.hazelcat;

import com.rogercw.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 2018/4/18.
 */
@Service("hazelcastCacheUserService")
public class UserService {
    private Map<Integer, User> users = new HashMap<Integer, User>();
    {
        users.put(1, new User("1", "zhangsan",18));
        users.put(2, new User("2", "lisi",20));
    }

    /**
     * 使用属性condition进行过滤,只有满足条件时才会进行缓存
     * 不满足条件时，每次都是调用真实的查询方法进行查询
     * @param user
     * @return
     */
    @Cacheable(value = "users", condition = "#user.age < 20")
    public User getUser(User user) {
        System.out.println("获取id为:"+user.getId()+"的用户信息");
        return users.get(Integer.valueOf(user.getId()));
    }
}
