package com.rogercw.proxy;

/**
 * Created by 1 on 2018/4/30.
 */
public class Monitor {

    private static ThreadLocal<MethodPerformance> threadLocal=new ThreadLocal<>();

    public static void start(String method){
        System.out.println("开启性能监视");
        MethodPerformance performance=new MethodPerformance(method);
        threadLocal.set(performance);
    }
    
    public static void end(){
        System.out.println("关闭性能监视");
        MethodPerformance performance = threadLocal.get();
        performance.printPerformance();

    }
}
