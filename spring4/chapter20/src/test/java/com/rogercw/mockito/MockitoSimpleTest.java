package com.rogercw.mockito;

import com.rogercw.domain.User;
import com.rogercw.service.UserService;
import static org.mockito.Mockito.*;

import com.rogercw.service.impl.UserServiceImpl;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by 1 on 2018/5/11.
 */
public class MockitoSimpleTest {

    private UserService mockUserService;

    @BeforeClass
    public void inti(){
        mockUserService=mock(UserServiceImpl.class);
    }

    @Test
    public void testMockService(){
        //模拟方法调用及设定返回值,当调用getUserById（）方法且方法参数为1时,
        // 返回一个User对象
        when(mockUserService.getUserById(1)).thenReturn(new User(1,"zhangsan","1234"));
        //通过doReturn（）.when（）语法,模拟判断用户getUserByUsernameAndPassword（）方法的调用
        //判断用户名为zhangsan,密码为1234的用户是否存在,并设置方法返回值为true
        doReturn(true).when(mockUserService).getUserByUsernameAndPassword("zhangsan","1234");

        //在设定调用方法及返回值之后,就可以执行接口方法进行调用验证
        User user=mockUserService.getUserById(1);
        boolean isExist=mockUserService.getUserByUsernameAndPassword("zhangsan","1234");
        assertNotNull(user);
        assertEquals(user.getUsername(),"zhangsan");
        assertTrue(isExist);
    }
}
