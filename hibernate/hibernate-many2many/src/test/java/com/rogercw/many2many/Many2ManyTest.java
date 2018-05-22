package com.rogercw.many2many;

import com.rogercw.dao.CourseDao;
import com.rogercw.dao.StudentDao;
import com.rogercw.domain.Course;
import com.rogercw.domain.Student;
import org.junit.Test;
import org.junit.experimental.max.CouldNotReadCoreException;

import java.util.Iterator;

/**
 * Created by 1 on 2018/5/14.
 */
public class Many2ManyTest {

    private StudentDao studentDao=new StudentDao();
    private CourseDao courseDao=new CourseDao();

    @Test
    public void addStudentTest() {
        Student s1 =new Student();
        s1.setStudentName("关羽");
        Student s2 =new Student();
        s2.setStudentName("张飞");

        Course c1=new Course();
        c1.setCourseName("数据结构");
        Course c2=new Course();
        c2.setCourseName("操作系统");
        Course c3=new Course();
        c3.setCourseName("网络工程");
        Course c4=new Course();
        c4.setCourseName("Java基础");

        s1.getCourses().add(c1);
        s1.getCourses().add(c3);

        s2.getCourses().add(c2);
        s2.getCourses().add(c3);
        s2.getCourses().add(c4);

        studentDao.add(s1);
        studentDao.add(s2);
    }

    @Test
    public void addNewStudentTest() {
        Student student=new Student();
        student.setStudentName("赵云");
        //加载课程
        Course course= (Course) courseDao.get(Course.class,1);
        student.getCourses().add(course);
        studentDao.add(student);
    }

    @Test
    public void addNewCourse() {
        Student zhaoyun= (Student) studentDao.get(Student.class,3);
        Student guanyu= (Student) studentDao.get(Student.class,1);
        Course course=new Course();
        course.setCourseName("编译原理");

        guanyu.getCourses().add(course);
        zhaoyun.getCourses().add(course);

        studentDao.update(guanyu);
        studentDao.update(zhaoyun);
    }

    /**
     * 删除学生,并删除其选课信息
     */
    @Test
    public void deleteStudent() {
        Student zhangfei= (Student) studentDao.get(Student.class,2);
        Iterator<Course> iterator = zhangfei.getCourses().iterator();
        //删除前先移除所选的课程
        if(iterator.hasNext()){
            Course course=iterator.next();
            course.getStudents().remove(zhangfei);
        }
        //将cascade设置为save-update
        studentDao.delete(zhangfei);
    }
}
