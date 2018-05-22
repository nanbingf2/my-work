package com.rogercw;

import com.rogercw.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 1 on 2018/5/18.
 * 入门演示
 */
public class DemoTest {

    @Test
    public void demoTest() throws IOException {
        InputStream stream =Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
        SqlSession session=factory.openSession();
        User user=new User();
        user.setName("jack");
        user.setAge(18);
        user.setSex("男");

        session.insert("com.rogercw.mapper.UserMapper.save",user);
        session.commit();
        session.close();
    }
}
