package roger.chen.simple;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by 1 on 2018/2/12.
 * 自定义任务
 */
public class MyJob implements Job{

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello Simple Test");
        System.out.println("当前时间:"+new Date());
    }
}
