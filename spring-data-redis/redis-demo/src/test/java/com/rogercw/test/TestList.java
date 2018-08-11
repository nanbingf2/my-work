package com.rogercw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/11 12:36
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValueTest1(){
        //右压栈：后添加的元素排在后面
        redisTemplate.boundListOps("name").rightPush("zhangsan");
        redisTemplate.boundListOps("name").rightPush("lisi");
        redisTemplate.boundListOps("name").rightPush("wangwu");
    }

    @Test
    public void getValueTest1(){
        List list = redisTemplate.boundListOps("name").range(0, 10);
        System.out.println(list);
    }


    @Test
    public void setValueTest2(){
        //左压栈：后放入的元素排在前面
        redisTemplate.boundListOps("name2").leftPush("zhangsan");
        redisTemplate.boundListOps("name2").leftPush("lisi");
        redisTemplate.boundListOps("name2").leftPush("wangwu");
    }

    @Test
    public void getValueTest2(){
        List list = redisTemplate.boundListOps("name2").range(0, 10);
        System.out.println(list);
    }

    @Test
    public void getValueByIndexTest(){
        //索引从0开始
        String name1= (String) redisTemplate.boundListOps("name").index(1);
        System.out.println(name1);
    }


    @Test
    public void removeValueTest(){
        //移除操作：第一个参数：移除的个数，第二个参数：移除的元素
        redisTemplate.boundListOps("name").remove(1,"zhangsan");
    }
}
