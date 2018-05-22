package com.rogercw.cache;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.User;
import com.rogercw.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/21.
 * 二级缓存测试
 */
public class Cache2Test {

    @Test
    public void cache1Test() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user1=userMapper.findById(5);
        System.out.println(user1);
        session.close();

        SqlSession session2=SqlSessionFactoryUtils.openSession();
        UserMapper userMapper2=session2.getMapper(UserMapper.class);
        User user2=userMapper2.findById(5);
        System.out.println(user2);
        session2.close();
    }

    @Test
    public void cache2Test() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user1=userMapper.findById(5);
        System.out.println(user1);

        //执行删除操作,提交后会清空一级缓存
        userMapper.deleteUser(4);
        //需要提交
        session.commit();

        User user2=userMapper.findById(5);
        System.out.println(user2);
        session.close();
    }

}
