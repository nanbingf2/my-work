package com.rogercw.dynamicsql;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.Employee;
import com.rogercw.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 1 on 2018/5/20.
 */
public class DynamicSqlTest {

    @Test
    public void selectEmployeeBySex() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        //List<Employee> employees=employeeMapper.selectEmployeeBySex(null);
        HashMap<String,Object> param=new HashMap<>();
        param.put("sex","男");
        List<Employee> employees=employeeMapper.selectEmployeeBySex(param);
        employees.forEach(employee->
                System.out.println(employee.getRealname()));
    }

    @Test
    public void selectByConditionTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        HashMap<String,Object> params=new HashMap<>();
        //params.put("loginname","reus");
        //params.put("id","2");
        List<Employee> employees = employeeMapper.selectByCondition(params);
        employees.forEach(employee ->
                System.out.println(employee.getRealname()));
    }

    @Test
    public void updateEmployeeTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        Employee employee=employeeMapper.selectEmployeeById(2);
        employee.setLoginname("关羽");
        employee.setRealname("云长");
        employee.setAge(25);
        employee.setSalary(6000);

        employeeMapper.updateEmployee(employee);
    }


    @Test
    public void selectEmployeeInTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(4);

        List<Employee> employees = employeeMapper.selectEmployeeIn(ids);
        employees.forEach(employee ->
                System.out.println(employee.getRealname()));
    }
}
