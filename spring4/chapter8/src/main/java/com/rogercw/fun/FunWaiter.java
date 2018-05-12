package com.rogercw.fun;

import com.rogercw.NeedTest;
import com.rogercw.Waiter;

/**
 * Created by 1 on 2018/5/5.
 */
public class FunWaiter implements Waiter {
    @NeedTest
    @Override
    public void greet(String name) {
        System.out.println("你好："+name);
    }

    @Override
    public void server(String name) {
        System.out.println("很高兴为你服务"+name);
    }
}
