package com.rogercw.advisor;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by 1 on 2018/5/1.
 * 静态普通方法名匹配切面
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor{
    /**
     * 该方法只用来匹配Waiter类的greet（）方法
     * @param method
     * @param clazz
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> clazz) {
        return clazz.getName().equals("com.rogercw.advisor.Waiter")&&method.getName().equals("greet");
    }
}
