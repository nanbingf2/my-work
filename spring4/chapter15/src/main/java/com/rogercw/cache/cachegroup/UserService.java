package com.rogercw.cache.cachegroup;

import com.rogercw.cache.domain.Member;
import com.rogercw.cache.domain.User;
import com.rogercw.cache.domain.Visitor;
import com.rogercw.cache.utils.UsersMapInit;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 2018/4/18.
 */
@Service("cacheGroupUserService")
public class UserService {
    private Map<Integer,User> usersMap=new HashMap<Integer,User>();
    {
        usersMap.put(1,new Member("1","zhangsan",15));
        usersMap.put(2,new Visitor("2","lisi",16));
    }

    @Caching(cacheable = {
        @Cacheable(cacheNames = "member",
                condition = "#user instanceof T(com.rogercw.cache.domain.Member)"),
            @Cacheable(cacheNames = "visitor",
                    condition = "#user instanceof T(com.rogercw.cache.domain.Visitor)")
    })
    public User getUser(User user){
        return usersMap.get(Integer.valueOf(user.getId()));
    }
}
