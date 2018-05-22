package com.rogercw.cache;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.User;
import com.rogercw.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/21.
 * 一级缓存测试:进行测试前,先不启用二级缓存
 */
public class CacheTest {

    @Test
    public void cache1Test() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user1=userMapper.findById(1);
        System.out.println(user1);
        User user2=userMapper.findById(1);
        System.out.println(user2);
        session.close();
    }


    @Test
    public void cache2Test() {
        SqlSession session = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user1 = userMapper.findById(2);
        System.out.println(user1);
        //执行了删除操作会清空一级缓存
        userMapper.deleteUser(3);
        session.commit();
        User user2 = userMapper.findById(2);
        System.out.println(user2);
        session.close();
    }


    @Test
    public void cache3Test() {
        SqlSession session = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user1 = userMapper.findById(2);
        System.out.println(user1);
        session.close();

        SqlSession session2 = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);
        User user2 = userMapper2.findById(2);
        System.out.println(user2);
        session.close();
    }
}
