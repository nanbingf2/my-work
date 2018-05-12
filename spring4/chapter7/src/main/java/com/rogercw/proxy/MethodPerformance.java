package com.rogercw.proxy;

/**
 * Created by 1 on 2018/4/30.
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin=System.currentTimeMillis();
    }

    public void printPerformance(){
        end=System.currentTimeMillis();
        System.out.println(serviceMethod+"消耗时间为:"+(end-begin));
    }
}
