package com.rogercw.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by 1 on 2018/5/1.
 */
public class MonitorController extends DelegatingIntroductionInterceptor implements Monitorable{

    private ThreadLocal<Boolean> statusMap=new ThreadLocal<>();

    @Override
    public void setMonitorActive(boolean active) {
        statusMap.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj=null;
        if(statusMap.get()!=null&&statusMap.get()){
            //active为true时,也就表示可以开启性能监控
            Monitor.start(mi.getClass().getName()+"."+mi.getMethod().getName());
            obj=super.invoke(mi);
            Monitor.end();
        }else{
            obj=super.invoke(mi);
        }
        return obj;
    }
}
