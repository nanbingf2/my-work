package com.rogercw.spring;

import com.rogercw.spring.service.LoginService;
import junit.framework.Assert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Created by 1 on 2018/5/11.
 */
@ContextConfiguration(locations = "classpath:testng-spring/application.xml")
public class TestNGSpring extends AbstractTestNGSpringContextTests{

    @Resource
    private LoginService loginService;

    @Test
    public void testLogin(){
        Assert.assertTrue(loginService.login("zhangsan","1234"));
        Assert.assertFalse(loginService.login("lisi","1234"));
        Assert.assertFalse(loginService.login("zhangsan","123456"));
    }
}
