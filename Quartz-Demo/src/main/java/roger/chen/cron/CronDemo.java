package roger.chen.cron;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import roger.chen.simple.MyJob;
import sun.util.resources.cldr.ms.CalendarData_ms_MY;

/**
 * Created by 1 on 2018/2/12.
 *表达式触发示例
 */
public class CronDemo {

    public void run() throws SchedulerException {
        //定义触发器
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        //定义JobDetail
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1","group1")
                .build();

        //定义触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triiger1","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();

        //将job和triiger注册到触发器中
        sched.scheduleJob(job,trigger);

        //启动调度器
        sched.start();

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //关闭调度器
        sched.shutdown();
    }

    public static void main(String[] args) throws SchedulerException {
        CronDemo demo =new CronDemo();
        demo.run();
    }
}
