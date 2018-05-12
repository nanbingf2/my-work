package com.rogercw.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by 1 on 2018/5/1.
 * 前置增强
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("对"+o.getClass().getName()+"的"+method.getName()+"方法进行增强");
        String name= (String) objects[0];
        System.out.println("欢迎光临"+name);
    }
}
