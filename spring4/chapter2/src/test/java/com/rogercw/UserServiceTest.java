package com.rogercw;

import com.rogercw.domain.User;
import com.rogercw.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.AssertJUnit.*;

/**
 * Created by 1 on 2018/4/5.
 */
@ContextConfiguration("classpath*:/spring-context.xml") //启动spring容器
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests{
    @Resource
    private UserService userService;

    @Test
    public void  hasMatchUser(){
        boolean b1=userService.hasMatchUser("admin","123456");
        boolean b2=userService.hasMatchUser("admin","111");
        assertTrue(b1);
        assertFalse(b2);
    }

    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("admin");
        assertEquals("admin",user.getUserName());
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
