package com.rogercw.dao;

import com.rogercw.HibernateSessionFactory;
import com.rogercw.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/15.
 */
public class UserDao {

    public void batchAddUser(){
        Session session= HibernateSessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            for (int i = 0; i < 10000; i++) {
                User user=new User();
                user.setName("user"+i);
                user.setPassword("12345");
                session.save(user);
                if (i%100==0){
                    //以100个数据作为一个处理单元,保持与数据库数据的同步
                    session.flush();
                    session.clear();
                }
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void batchUpdateUser(){
        Session session=HibernateSessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query=session.createQuery("update User set password='111111' where id>5");
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void batchDeleteUser(){
        Session session=HibernateSessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query=session.createQuery("delete User where id>5000");
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
