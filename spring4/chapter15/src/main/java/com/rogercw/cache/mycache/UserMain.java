package com.rogercw.cache.mycache;

/**
 * Created by 1 on 2018/4/16.
 * 测试类
 */
public class UserMain {
    public static void main(String[] args) {
        UserService userService=new UserService();

        //开始查询账号,由于缓存里没有数据,会从数据库里查找
        userService.getUserById("0001");
        //第二次会直接从缓存里查找
        userService.getUserById("0001");

        //清空缓存
        userService.reload();
        System.out.println("after reload.....");
        //清空后会从数据库中查找数据
        userService.getUserById("0001");
        //从缓存中查找
        userService.getUserById("0001");
    }
}
