package com.rogercw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @Author: rogercw
 * @Date: 2018/8/11 12:51
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestHash {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValueTest(){
        redisTemplate.boundHashOps("nameHash").put("a","zhangsan");
        redisTemplate.boundHashOps("nameHash").put("b","lisi");
        redisTemplate.boundHashOps("nameHash").put("c","wangwu");
        redisTemplate.boundHashOps("nameHash").put("d","zhaoliu");
    }

    @Test
    public void getAllKeysTest(){
        Set keys = redisTemplate.boundHashOps("nameHash").keys();
        System.out.println(keys);
    }

    @Test
    public void getAllValuesTest(){
        List list = redisTemplate.boundHashOps("nameHash").values();
        System.out.println(list);
    }

    @Test
    public void getValueByKeyTest(){
        String name = (String) redisTemplate.boundHashOps("nameHash").get("a");
        System.out.println(name);
    }


    @Test
    public void deleteValueByKeyTest(){
        redisTemplate.boundHashOps("nameHash").delete("a");
    }
}
