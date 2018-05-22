package com.rogercw.cache;

import com.rogercw.HibernateSessionFactory;
import com.rogercw.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.service.UnknownServiceException;
import org.junit.Test;

import java.util.List;

/**
 * Created by 1 on 2018/5/22.
 * 查询缓存测试
 */
public class QueryCacheTest {

    /**
     * 在没有使用query.setCacheable(true)来开启查询缓存时,
     * 对于以SQL语句的方式来获取查询结果时,是不会从缓存中获取数据的
     * 也就是说下面测试代码会输出两次查询语句
     */
    @Test
    public void cacheTest() {
        Session session= HibernateSessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from User");
        List<User> users=query.list();
        users.forEach(user-> System.out.println(user));
        session.getTransaction().commit();
        session.close();

        System.out.println("*****************************");

        Session session2=HibernateSessionFactory.openSession();
        session2.beginTransaction();
        Query query2=session2.createQuery("from User");
        List<User> user2=query2.list();
        user2.forEach(user -> System.out.println(user));
    }

    /**
     * 开启查询缓存的测试,
     * 使用相同的SQL语句进行第二次查询时会从缓存中获取结果
     * 不会输出查询语句从数据库中进行查询
     */
    @Test
    public void queryCacheTest() {
        Session session= HibernateSessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from User");
        //开启查询缓存
        query.setCacheable(true);
        List<User> users=query.list();
        users.forEach(user-> System.out.println(user));
        session.getTransaction().commit();
        session.close();

        Session session2=HibernateSessionFactory.openSession();
        session2.beginTransaction();
        Query query2=session2.createQuery("from User");
        query2.setCacheable(true);
        List<User> user2=query2.list();
        System.out.println("*****************************");
        user2.forEach(user -> System.out.println(user));
    }
}
