package com.rogercw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 1 on 2018/4/30.
 */
public class PerformanceHandler implements InvocationHandler{
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Monitor.start(target.getClass().getName()+"."+method.getName());
        Object obj = method.invoke(target,args);
        Monitor.end();
        return obj;
    }
}
