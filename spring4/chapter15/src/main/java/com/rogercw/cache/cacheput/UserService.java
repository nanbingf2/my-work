package com.rogercw.cache.cacheput;

import com.rogercw.cache.domain.User;
import com.rogercw.cache.utils.UsersMapInit;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 2018/4/17.
 */
@Service(value="cachePutUserservice")
public class UserService {
    //定义一个Map集合作为数据来源
    Map<Integer,User> usersMap= UsersMapInit.initUsersMap();

    //CachePut注解首先执行方法，然后将返回值保存到方法中
    @CachePut(cacheNames="users")
    public User getUserById(int id){
        System.out.println("查找id为:" + id + "的用户");
        return usersMap.get(id);
    }

}
