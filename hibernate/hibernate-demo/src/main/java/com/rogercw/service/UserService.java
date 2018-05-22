package com.rogercw.service;


import com.rogercw.HibernateSessionFactory;
import com.rogercw.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by 1 on 2018/5/12.
 */
public class UserService {


    /**
     * 保存数据
     * @param user
     */
    public void addUser(UserEntity user){
        Session session= HibernateSessionFactory.openSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 使用get（）方法获取对象
     * @param id
     * @return
     */
    public UserEntity getUser(int id){
        Session session= HibernateSessionFactory.openSession();
        UserEntity user=session.get(UserEntity.class,id);
        return user;
    }

    /**
     * 使用load（）方法加载对象
     * @param id
     * @return
     */
    public UserEntity loadUser(int id){
        Session session= HibernateSessionFactory.openSession();
        UserEntity user=session.load(UserEntity.class,id);
        return user;
    }

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(int id){
        Session session= HibernateSessionFactory.openSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            UserEntity user=session.get(UserEntity.class,id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateUser(int id){
        Session session= HibernateSessionFactory.openSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            //查找需要修改的对象
            UserEntity user= session.get(UserEntity.class,id);
            //修改数据
            user.setName("关羽");
            user.setPassword("88888");
            //执行数据更新操作
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
