package com.rogercw.mapper;

import com.rogercw.domain.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 1 on 2018/5/20.
 */
public interface EmployeeMapper {

    public List<Employee> selectEmployeeBySex(HashMap<String,Object> param);

    public List<Employee> selectByCondition(HashMap param);

    public void updateEmployee(Employee employee);

    public Employee selectEmployeeById(int id);

    public List<Employee> selectEmployeeIn(List<Integer> ids);
}
