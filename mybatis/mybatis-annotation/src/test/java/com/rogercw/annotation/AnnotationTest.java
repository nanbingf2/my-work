package com.rogercw.annotation;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.Clazz;
import com.rogercw.domain.Employee;
import com.rogercw.domain.Order;
import com.rogercw.domain.Person;
import com.rogercw.mapper.ClazzMapper;
import com.rogercw.mapper.EmployeeMapper;
import com.rogercw.mapper.OrderMapper;
import com.rogercw.mapper.PersonMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by 1 on 2018/5/21.
 */
public class AnnotationTest {

    @Test
    public void insertTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        Employee employee=new Employee();
        employee.setLoginname("常山赵子龙");
        employee.setPassword("5555");
        employee.setRealname("赵云");
        employee.setAge(28);
        employee.setSex("男");
        employee.setSalary(12000);
        mapper.insertEmployeeSQL(employee);
        session.commit();
        session.close();
    }


    @Test
    public void selectByIdTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        Employee employee=mapper.selectEmployeeById(7);
        System.out.println(employee);
        session.close();
    }

    @Test
    public void selectAllTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        List<Employee> employees=mapper.selectAllEmployees();
        employees.forEach(employee-> System.out.println(employee));
        session.close();
    }

    @Test
    public void updateTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        Employee employee=mapper.selectEmployeeById(7);
        employee.setLoginname("赵子龙");
        mapper.updateEmployee(employee);
        session.commit();
        session.close();
    }

    @Test
    public void deleteTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        mapper.deleteEmployee(7);
        session.commit();
        session.close();
    }


    @Test
    public void one2oneTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        PersonMapper personMapper=session.getMapper(PersonMapper.class);
        Person person=personMapper.selectPersonById(1);
        System.out.println(person);
        session.close();
    }


    @Test
    public void one2ManyTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        ClazzMapper clazzMapper=session.getMapper(ClazzMapper.class);
        Clazz clazz=clazzMapper.selectClazzById(1);
        System.out.println(clazz.getName()+"*****"+clazz.getCode());
        clazz.getStudents().forEach(student-> System.out.println(student.getName()));
    }

    @Test
    public void many2ManyTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        OrderMapper orderMapper=session.getMapper(OrderMapper.class);
        Order order=orderMapper.selectOrderById(1);
        System.out.println("***********************");
        System.out.println(order.getCode());
        System.out.println(order.getUser().getLoginname());
        order.getArticles().forEach(article -> System.out.println(article.getName()));
    }


}

