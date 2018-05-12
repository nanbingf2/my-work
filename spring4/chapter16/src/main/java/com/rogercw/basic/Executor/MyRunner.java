package com.rogercw.basic.Executor;

/**
 * Created by 1 on 2018/4/21.
 */
public class MyRunner implements Runnable{
    private String taskName;

    public MyRunner(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("当前执行的任务名为:"+this.taskName);
    }
}
