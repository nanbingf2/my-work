package com.rogercw.demo;

import com.rogercw.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/12.
 */
public class DemoTest {

    @Test
    public void demoTest(){
        //准备数据
        UserEntity user=new UserEntity();
        user.setName("zhangsan");
        user.setPassword("1234");

        //加载配置文件获得核心配置对象
        Configuration configuration=new Configuration().configure();
        //获得SessionFactory对象,相当于连接池
        SessionFactory factory=configuration.buildSessionFactory();
        //获得Session对象
        Session session=factory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //保存操作
        session.save(user);
        //提交事务
        transaction.commit();
        //管壁资源
        session.close();
        factory.close();
    }
}
