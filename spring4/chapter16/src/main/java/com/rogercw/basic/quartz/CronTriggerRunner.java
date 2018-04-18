package com.rogercw.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * Created by 1 on 2018/4/18.
 * 使用CronTrigger来触发
 */
public class CronTriggerRunner {
    public static void main(String[] args) throws SchedulerException, ParseException {
        //创建调度器实例
        SchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        //创建JobDetail对象
        JobDetail jobDetail=new JobDetail("job2","jobGroup2",MyJob.class);
        //创建Cron表达式对象:在每分钟里的第0秒和第5秒执行
        CronExpression expression=new CronExpression("0,5 * * * * ?");
        //创建CronTrigger对象
        CronTrigger trigger=new CronTrigger("trigger2","trigger2Group");
        //设置Cron表达式
        trigger.setCronExpression(expression);
        //将jobDetail和trigger注册到调度器中
        scheduler.scheduleJob(jobDetail,trigger);
        //启动调度器
        scheduler.start();
    }
}
