package com.rogercw.cache.utils;

import com.rogercw.cache.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 2018/4/17.
 */
public class UsersMapInit {
    public static Map<Integer,User> initUsersMap(){
        Map<Integer,User> usersMap=new HashMap<Integer,User>();
        usersMap.put(1,new User("001","zhansan",15));
        usersMap.put(2,new User("002","lisi",16));
        usersMap.put(3,new User("003","tom",18));
        usersMap.put(4,new User("004","jerry",19));
        return usersMap;
    }
}
