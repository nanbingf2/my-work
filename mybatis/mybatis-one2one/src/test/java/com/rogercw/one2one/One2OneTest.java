package com.rogercw.one2one;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.Person;
import com.rogercw.mapper.PersonMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/18.
 */
public class One2OneTest {

    @Test
    public void selectPersonByIdTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        PersonMapper personMapper=session.getMapper(PersonMapper.class);
        Person person=personMapper.selectPersonById(1);
        System.out.println(person);
    }
}
