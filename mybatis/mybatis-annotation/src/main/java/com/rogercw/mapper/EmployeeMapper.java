package com.rogercw.mapper;

import com.rogercw.domain.Employee;
import com.rogercw.provider.DynamicSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 1 on 2018/5/21.
 */
public interface EmployeeMapper {

    /**
     * 插入员工
     * @param employee
     */
    @Insert("INSERT INTO t_employee(loginname,password,realname,sex,age,salary,phone) " +
            "VALUES(#{loginname},#{password},#{realname},#{sex},#{age},#{salary},#{phone})")
    @Options(useGeneratedKeys =true,keyProperty = "#{id}")
    public void insertEmployee(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     */
    @Update("UPDATE t_employee SET " +
            "loginname=#{loginname}," +
            "password=#{password}," +
            "realname=#{realname}," +
            "sex=#{sex}," +
            "age=#{age}," +
            "salary=#{salary}," +
            "phone=#{phone} " +
            "WHERE id=#{id}")
    public void updateEmployee(Employee employee);


    /**
     * 删除员工信息
     * @param id
     */
    @Delete("DELETE FROM t_employee WHERE id=#{id}")
    public void deleteEmployee(int id);


    /**
     * 查询员工信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM t_employee WHERE id=#{id}")
    @Results({
        @Result(id = true,property = "id",column = "id"),
            @Result(property = "loginname",column = "loginname"),
            @Result(property = "password",column = "password"),
            @Result(property = "realname",column = "realname"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            @Result(property = "salary",column = "salary"),
            @Result(property = "phone",column = "phone"),
    })
    public Employee selectEmployeeById(int id);


    /**
     * 查询所有员工信息
     * @return
     */
    @Select("SELECT * FROM t_employee")
    public List<Employee> selectAllEmployees();


    //*************************动态SQL******************************

    @SelectProvider(type = DynamicSQLProvider.class,method = "selectEmployeeByParam")
    public List<Employee> selectEmployeeByParamSQL(Employee employee);

    @InsertProvider(type=DynamicSQLProvider.class,method = "insertEmployee")
    public void insertEmployeeSQL(Employee employee);

    @DeleteProvider(type=DynamicSQLProvider.class,method = "deleteEmployee")
    public void deleteEmployeeSQL(Employee employee);

    @UpdateProvider(type=DynamicSQLProvider.class,method = "updateEmployee")
    public void updateEmployeeSQL(Employee employee);
}
