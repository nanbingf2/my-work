package roger.chen.simple;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by 1 on 2018/2/12.
 */
public class SimpleDemo {

    public void run() throws SchedulerException {
        //定义调度器
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        //定义JobDetail,任务名称和所属组合起来必须唯一
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1","group1")
                .build();

        //触发时间:当前时间的下一分钟
        Date runTime = DateBuilder.evenMinuteDate(new Date());


        //定义触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startAt(runTime)
                .build();

        //将Job,Trigger注册到调度器中
        scheduler.scheduleJob(job,trigger);

        System.out.println("当前时间："+new Date());

        //启动调度器
        scheduler.start();

        //暂停65秒
        try {
            Thread.sleep(65000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //关闭调度器
        scheduler.shutdown();

    }

    public static void main(String[] args) throws SchedulerException {
        SimpleDemo demo = new SimpleDemo();
        demo.run();
    }
}
