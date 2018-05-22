package com.rogercw.mapper;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.User;
import org.apache.ibatis.session.SqlSession;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/18.
 * 基于Mapper代理的测试
 */
public class UserMapperTest {

    @Test
    public void findByIdTest() {
        SqlSession session = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findById(3);
        assertNotNull(user);
        assertEquals(user.getId(),3);
    }

    @Test
    public void insertUserTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=new User();
        user.setName("jimmy");
        user.setSex("男");
        user.setAge(20);
        int id=userMapper.insertUser(user);
        session.commit();
        System.out.println(id);
        session.close();
    }


    @Test
    public void updateUserTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user=userMapper.findById(3);
        user.setName("reus");
        userMapper.updateUser(user);
        session.commit();
        session.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.deleteUser(8);
        session.commit();
        session.close();
    }

    @Test
    public void findUserTotalTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        int total = userMapper.findUserTotal();
        System.out.println(total);
        session.close();
    }

    @Test
    public void selectResultMapTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.selectResultMap(3);
        System.out.println(user);
    }
}
