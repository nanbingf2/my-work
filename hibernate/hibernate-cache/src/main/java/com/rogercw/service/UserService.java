package com.rogercw.service;

import com.rogercw.HibernateSessionFactory;
import com.rogercw.entity.User;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/15.
 */
public class UserService {

   public User getUser(int id){
       Session session=HibernateSessionFactory.openSession();
       return session.get(User.class,id);
   }
}
