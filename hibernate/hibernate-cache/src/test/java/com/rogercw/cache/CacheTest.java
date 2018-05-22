package com.rogercw.cache;

import com.rogercw.HibernateSessionFactory;
import com.rogercw.entity.User;
import com.rogercw.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.Serializable;

/**
 * Created by 1 on 2018/5/15.
 */
public class CacheTest {

    private UserService userService=new UserService();

    /**
     * 在同一个Session中发出两次get查询
     * 在第二次查询时由于在一级缓存中查询出了数据,因此不会查询数据库
     * 控制台只会输出第一次查询时的sql语句
     */
    @Test
    public void getFromOneSessionTest() {
        User user1=userService.getUser(5);
        System.out.println(user1.getName());

        User user2=userService.getUser(5);
        System.out.println(user2.getName());
    }

    /**
     * 开启两个session，发出两个get查询
     * 由于在查询出第一个对象后session关闭了
     * 一级缓存也就关闭了,所以控制台会输出两条查询语句
     */
    @Test
    public void getFromTwoSessionTest() {
        Session session1= HibernateSessionFactory.openSession();
        User user1=session1.get(User.class,5);
        System.out.println(user1.getName());
        session1.close();

        Session session2=HibernateSessionFactory.openSession();
        User user2=session2.get(User.class,5);
        System.out.println(user2.getName());
        session2.close();
    }

    /**
     * 在同一个session中发出两次iterator查询
     * 在执行iterator.next()方法时,会发出查询id的sql语句,得到对象user1
     * 在使用user1获取name属性时才会发出查询实体对象的sql语句
     * 在第二次使用iterator.next()方法时,会发出查询id的sql语句,得到对象user2
     * 由于相同实体对象的已经缓存了,所以在获取那么属性时不会输出查询语句
     */
    @Test
    public void iterateTest() {
        Session session=HibernateSessionFactory.openSession();
        User user1= (User) session.createQuery("from User where id=5").iterate().next();
        System.out.println(user1.getName());

        User user2= (User) session.createQuery("from User where id =5").iterate().next();
        System.out.println(user2.getName());
        session.close();
    }


    /**
     * 使用iterator查询属性时,一级缓存不会缓存数据
     */
    @Test
    public void iteratorFiledTest() {
        Session session= HibernateSessionFactory.openSession();
        String name1= (String) session.createQuery("select name from User where id=5").iterate().next();
        System.out.println(name1);

        String name2= (String) session.createQuery("select name from User where id=5").iterate().next();
        System.out.println(name2);
        session.close();
    }

    /**
     * 在一个session中先执行save操作时,会在缓存里存放一份
     * 从而执行查询时,会直接在缓存里面查找,因此不会输出查询语句
     */
    @Test
    public void save_loadTest() {
        Session session=HibernateSessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        User user =new User();
        user.setName("曹操");
        user.setPassword("12356");
        Serializable id = session.save(user);
        tx.commit();

        User user1=session.get(User.class,id);
        System.out.println(user1.getName());
    }
}
