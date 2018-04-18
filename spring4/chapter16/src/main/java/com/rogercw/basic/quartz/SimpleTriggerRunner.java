package com.rogercw.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by 1 on 2018/4/18.
 * 使用SimpleTrigger来触发
 */
public class SimpleTriggerRunner {
    public static void main(String[] args) throws SchedulerException {
        //创建调度器实例
        SchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        //创建JobDetail对象,并指定自定义的任务
        //需要注意的是:在1.8.6版本中JobDetail、Trigger是一个类,而在2.2.1版本中变成了接口
        JobDetail jobDetail=new JobDetail("job1","jobgroup1",MyJob.class);

        //创建简单触发器对象,并指定触发器名称和所属组名
        SimpleTrigger trigger=new SimpleTrigger("trigger1","triggerGroup1");
        //设置触发器的启动时间,执行时间间隔,执行次数等
        trigger.setStartTime(new Date());
        trigger.setRepeatInterval(2000);
        trigger.setRepeatCount(10);

        //将JobDetails和触发器注册到调度器中
        scheduler.scheduleJob(jobDetail,trigger);
        //启动调度器
        scheduler.start();

    }
}
