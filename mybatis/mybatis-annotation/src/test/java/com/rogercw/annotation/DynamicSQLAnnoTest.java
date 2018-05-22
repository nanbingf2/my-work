package com.rogercw.annotation;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.Employee;
import com.rogercw.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by 1 on 2018/5/21.
 */
public class DynamicSQLAnnoTest {

    @Test
    public void selectEmployeeByParamTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        Employee employee=new Employee();
        employee.setLoginname("zhangsan");
        List<Employee> employees=mapper.selectEmployeeByParamSQL(employee);
        employees.forEach(e -> System.out.println(e));
    }


    @Test
    public void insertEmployeeTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        Employee employee=new Employee();
        employee.setLoginname("锦马超");
        employee.setPassword("88888");
        employee.setRealname("马超");
        employee.setAge(26);
        employee.setSex("男");
        employee.setSalary(89000);

        mapper.insertEmployeeSQL(employee);
        session.commit();
        session.close();
    }

    @Test
    public void updateEmployeeTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        Employee employee=mapper.selectEmployeeById(8);
        employee.setLoginname("锦马超");
        employee.setPassword("88888");
        employee.setRealname("马超");
        employee.setAge(26);
        employee.setSex("男");
        employee.setSalary(89000);

        mapper.updateEmployeeSQL(employee);
        session.commit();
        session.close();
    }

    @Test
    public void deleteEmployeeTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        Employee employee=new Employee();
        employee.setId(8);
        mapper.deleteEmployeeSQL(employee);
        session.commit();
        session.close();
    }
}
