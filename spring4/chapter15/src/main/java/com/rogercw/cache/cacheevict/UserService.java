package com.rogercw.cache.cacheevict;

import com.rogercw.cache.domain.User;
import com.rogercw.cache.utils.UsersMapInit;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by 1 on 2018/4/17.
 */
@Service(value = "cacheEvictUserService")
public class UserService {
    private Map<Integer,User> usersMap= UsersMapInit.initUsersMap();

    //@CacheEvict注解会从缓存中移除一个值
    @CacheEvict(cacheNames = "users")
    public void removeUser(int id){
        usersMap.remove(id);
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        System.out.println("查询用户信息");
        return usersMap.get(id);
    }
}
