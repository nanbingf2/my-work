package com.rogercw.cache;

import com.rogercw.HibernateSessionFactory;
import com.rogercw.entity.User;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/16.
 * 二级缓存测试
 */
public class Cache2Test {

    @Test
    public void getTest() {
        Session session= HibernateSessionFactory.openSession();
        User user1= session.get(User.class,4);
        System.out.println(user1);

        //关闭session
        session.close();

        Session session2=HibernateSessionFactory.openSession();
        User user2= session2.get(User.class,4);
        System.out.println(user2);

        session2.close();
    }
}
