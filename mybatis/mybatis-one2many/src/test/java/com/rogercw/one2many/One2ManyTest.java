package com.rogercw.one2many;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.Clazz;
import com.rogercw.domain.Student;
import com.rogercw.mapper.ClazzMapper;
import com.rogercw.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/19.
 */
public class One2ManyTest {

    @Test
    public void selectStudentByIdTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        Student student = studentMapper.selectStudentById(1);
        System.out.println(student);
    }


    @Test
    public void selectClazzByIdTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        ClazzMapper mapper=session.getMapper(ClazzMapper.class);
        Clazz clazz=mapper.selectClazzById(1);
        System.out.println(clazz.getName());
        clazz.getStudents().forEach(student->
                System.out.println(student.getName()));
    }
}
