package com.rogercw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @Author: rogercw
 * @Date: 2018/8/11 12:27
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestSet {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValueTest(){
        redisTemplate.boundSetOps("name").add("zhangsan");
        redisTemplate.boundSetOps("name").add("lisi");
        redisTemplate.boundSetOps("name").add("wangwu");
    }

    @Test
    public void getValueTest(){
        Set set = redisTemplate.boundSetOps("name").members();
        System.out.println(set);
    }

    @Test
    public void removeValueTest(){
        redisTemplate.boundSetOps("name").remove("zhangsan");
    }

    @Test
    public void deleteTest(){
        redisTemplate.delete("name");
    }
}
