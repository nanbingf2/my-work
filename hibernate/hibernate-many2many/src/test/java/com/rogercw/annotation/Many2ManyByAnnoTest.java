package com.rogercw.annotation;

import com.rogercw.dao.CourseDao;
import com.rogercw.dao.StudentDao;
import com.rogercw.entity.Course;
import com.rogercw.entity.Student;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by 1 on 2018/5/14.
 */
public class Many2ManyByAnnoTest {

    private StudentDao studentDao=new StudentDao();
    private CourseDao courseDao=new CourseDao();

    @Test
    public void addStudentTest() {
        Student s1=new Student();
        Course course=new Course();
        course.setCourseName("javaWeb基础");
        s1.setStudentName("马超");
        s1.getCourses().add(course);
        studentDao.add(s1);
    }

    @Test
    public void addNewStudentTest() {
        Student student=new Student();
        student.setStudentName("黄忠");
        Course course= (Course) courseDao.get(Course.class,6);
        student.getCourses().add(course);
        studentDao.add(student);
    }


    @Test
    public void deleteStudentTest() {
        Student student= (Student) studentDao.get(Student.class,4);
        Iterator iterator=student.getCourses().iterator();
        while(iterator.hasNext()){
            Course course= (Course) iterator.next();
            course.getStudents().remove(student);
        }
        studentDao.delete(student);
    }
}
