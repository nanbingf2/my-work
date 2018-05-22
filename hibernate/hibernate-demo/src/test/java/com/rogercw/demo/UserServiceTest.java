package com.rogercw.demo;

import com.rogercw.entity.UserEntity;
import com.rogercw.service.UserService;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/12.
 */
public class UserServiceTest {

    private UserService userService=new UserService();

    @Test
    public void addUserTest() {
        UserEntity user=new UserEntity();
        user.setName("zhangsan");
        user.setPassword("12222");
        user.setAddress("长沙");
        userService.addUser(user);
    }

    @Test
    public void getUserTest() {
        //获取存在的用户
        UserEntity user = userService.getUser(5);
        assertEquals(user.getName(),"zhangsan");
        //获取不存在的用户
        UserEntity user2=userService.getUser(100);
        assertNull(user2);
    }

    @Test
    public void loadUserTest() {
        UserEntity user = userService.loadUser(4);
        assertEquals(user.getName(),"lisi");
        //获取不存在的用户将抛出异常
        //userService.loadUser(100);
    }

    @Test
    public void deleteUserTest() {
        userService.deleteUser(3);
    }

    @Test
    public void updateUserTest() {
        userService.updateUser(5);
    }
}
