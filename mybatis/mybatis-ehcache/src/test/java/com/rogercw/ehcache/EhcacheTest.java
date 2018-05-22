package com.rogercw.ehcache;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.User;
import com.rogercw.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/21.
 */
public class EhcacheTest {

    @Test
    public void ehcacheTest() {
        SqlSession sessionn1= SqlSessionFactoryUtils.openSession();
        SqlSession sessionn2= SqlSessionFactoryUtils.openSession();
        SqlSession sessionn3= SqlSessionFactoryUtils.openSession();

        UserMapper userMapper1=sessionn1.getMapper(UserMapper.class);
        UserMapper userMapper2=sessionn2.getMapper(UserMapper.class);
        UserMapper userMapper3=sessionn3.getMapper(UserMapper.class);

        User user1=userMapper1.findById(5);
        System.out.println(user1);
        System.out.println("****************************");
        sessionn1.close();

        //从缓存中查询
        User user2=userMapper2.findById(5);
        System.out.println(user2);
        System.out.println("****************************");
        //更新数据并提交,
        user2.setName("herry");
        userMapper2.updateUser(user2);
        sessionn2.commit();
        sessionn2.close();

        User user3=userMapper3.findById(5);
        System.out.println(user3);
        sessionn3.close();

    }
}
