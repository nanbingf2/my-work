package com.rogercw.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 1 on 2018/4/18.
 */
public class CalendarDemo {

    public static void main(String[] args) throws SchedulerException {
        //创建调度器
        SchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        //创建AnnucalCalendar对象
        AnnualCalendar holidays=new AnnualCalendar();

        //劳动节
        Calendar laborDay = new GregorianCalendar();
        laborDay.add(Calendar.MONTH,5);
        laborDay.add(Calendar.DATE,1);

        //国庆节
        Calendar nationDay=new GregorianCalendar();
        nationDay.add(Calendar.MONTH,10);
        nationDay.add(Calendar.DATE,1);

        //排除两个特殊日期
        ArrayList<Calendar> executeCalendar=new ArrayList<Calendar>();
        executeCalendar.add(nationDay);
        executeCalendar.add(laborDay);
        holidays.setDaysExcluded(executeCalendar);

        //向调度器注册日历
        //holidays:日历规则的名称
        scheduler.addCalendar("holidays",holidays,false,false);

        //创建JobDetail对象
        JobDetail jobDetail=new JobDetail("job","jobGroup",MyJob.class);
        //创建触发器对象
        //该构造函数个参数的含义分别表示:
        // trigger名称,组名,开始执行时间,结束时间,执行次数,执行时间间隔
        SimpleTrigger trigger=new SimpleTrigger("trigger","triggerGroup",
                new Date(),null,
                SimpleTrigger.REPEAT_INDEFINITELY,60*60*1000);
        //为触发器设置指定的日历规则
        trigger.setCalendarName("holidays");
        scheduler.scheduleJob(jobDetail,trigger);
        //启动触发器
        scheduler.start();
    }
}
