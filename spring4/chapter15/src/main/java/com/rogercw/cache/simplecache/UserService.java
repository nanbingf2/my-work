package com.rogercw.cache.simplecache;

import com.rogercw.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by 1 on 2018/4/16.
 * 使用Spring Cache来实现缓存
 */
@Service(value = "simpleCacheUserService")
public class UserService {
    //使用名为users的缓存
    @Cacheable(cacheNames = "users")
    public User getUserById(String id){
        System.out.println("执行用户查询方法查找用户");
        return getFromDB(id);
    }

    private User getFromDB(String id) {
        System.out.println("从数据库中查找用户");
        return new User(id,"lisi",19);
    }


}
