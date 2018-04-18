package com.rogercw.basic.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by 1 on 2018/4/18.
 * 自定义任务
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("当前触发器的名称是:"+jobExecutionContext.getTrigger().getName()+",当前触发时间是:"+new Date());

    }
}
