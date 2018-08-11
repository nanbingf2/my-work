package com.rogercw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author: rogercw
 * @Date: 2018/8/11 10:35
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValueTest(){
        redisTemplate.boundValueOps("name").set("zhangsan");
    }

    @Test
    public void getValueTest(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        //assertEquals("zhangsan",name);
        System.out.println(name);
    }

    @Test
    public void deleteValueTest(){
        redisTemplate.delete("name");
    }
}
