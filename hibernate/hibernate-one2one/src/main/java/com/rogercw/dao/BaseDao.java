package com.rogercw.dao;

import com.rogercw.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by 1 on 2018/5/12.
 */
public class BaseDao {

    /**
     * 保存操作
     * @param object
     */
    public void add(Object object){
        Transaction transaction=null;
        Session session= HibernateSessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.getMessage();
        } finally {
            session.close();
        }
    }

    /**
     * 查詢操作
     * @param clazz
     * @param id
     * @return
     */
    public Object get(Class clazz,int id){
        Object obj=null;
        Session session=HibernateSessionFactory.openSession();
        try {
            obj=session.find(clazz,id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * 刪除操作
     * @param obj
     */
    public void delete(Object obj){
        Transaction tx=null;
        Session session=HibernateSessionFactory.openSession();
        try {
            tx=session.beginTransaction();
            session.delete(obj);
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

    /**
     * 修改操作
     * @param obj
     */
    public void update(Object obj){
        Transaction tx=null;
        Session session=HibernateSessionFactory.openSession();
        tx.commit();
        try {
            tx=session.beginTransaction();
            session.update(obj);
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
