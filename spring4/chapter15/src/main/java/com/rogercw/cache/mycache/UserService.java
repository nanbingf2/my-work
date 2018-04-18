package com.rogercw.cache.mycache;

import com.rogercw.cache.domain.User;

/**
 * Created by 1 on 2018/4/16.
 */
public class UserService {

    private CacheManager<User> cacheManager;

    //在构造方法中初始化一个自定义的缓存管理器
    public UserService() {
        this.cacheManager=new CacheManager<User>();
    }

    public User getUserById(String id){
        //首先从缓存里查找
        User user = cacheManager.getValue(id);
        if (user != null) {
            System.out.println("从缓存中查找到了数据");
            //缓存中查找到了数据,则直接将其返回
            return user;
        }
        //否则从数据库中查找
        user=getFromDB(id);
        if (user != null) {
            //从数据库中查找到了数据,在返回之前将其写入到缓存管理器之中
            cacheManager.addOrUpdateCache(id,user);
        }
        return user;
    }

    private User getFromDB(String id) {
        System.out.println("从数据库中查找数据......");
        return new User(id,"张三",15);
    }

    //重置缓存
    public void reload(){
        cacheManager.evictAll();
    }

}
