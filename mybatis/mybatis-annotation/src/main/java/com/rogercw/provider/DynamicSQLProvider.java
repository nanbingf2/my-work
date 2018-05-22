package com.rogercw.provider;

import com.rogercw.domain.Employee;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by 1 on 2018/5/21.
 */
public class DynamicSQLProvider {

    public String selectEmployeeByParam(Employee employee){
        return new SQL(){{
            SELECT("*");
            FROM("t_employee");
            if (employee.getId()!=0){
                WHERE(" id=#{id}");
            }
            if (employee.getLoginname()!=null) {
                WHERE(" loginname=#{loginname}");
            }
            if (employee.getPassword() != null) {
                WHERE(" password=#{password}");
            }
            if (employee.getSex() != null) {
                WHERE(" sex=#{sex}");
            }
            if (employee.getPhone() != null) {
                WHERE(" phone=#{phone}");
            }
        }
        }.toString();
    }


    public String insertEmployee(Employee employee){
        return new SQL(){
            {
                INSERT_INTO("t_employee");
                if (employee.getLoginname()!=null){
                    VALUES("loginname","#{loginname}");
                }
                if (employee.getPassword() != null) {
                    VALUES("password","#{password}");
                }
                if (employee.getRealname() != null) {
                    VALUES("realname","#{realname}");
                }
                if(employee.getAge()!=0){
                    VALUES("age","#{age}");
                }
                if (employee.getSex() != null) {
                    VALUES("sex","#{sex}");
                }
                if (employee.getPhone() != null) {
                    VALUES("phone","#{phone}");
                }
                if (employee.getSalary()!=0){
                    VALUES("salary","#{salary}");
                }
            }
        }.toString();
    }


    public String updateEmployee(Employee employee){
        return new SQL(){
            {
                UPDATE("t_employee");
                if (employee.getLoginname()!=null){
                    SET("loginname=#{loginname}");
                }
                if (employee.getPassword() != null) {
                    SET("password=#{password}");
                }
                if (employee.getRealname() != null) {
                    SET("realname=#{realname}");
                }
                if(employee.getAge()!=0){
                    SET("age=#{age}");
                }
                if (employee.getSex() != null) {
                    SET("sex=#{sex}");
                }
                if (employee.getPhone() != null) {
                    SET("phone=#{phone}");
                }
                if (employee.getSalary()!=0){
                    SET("salary=#{salary}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String deleteEmployee(Employee employee){
            return new SQL(){
                {
                    DELETE_FROM("t_employee");
                    if (employee.getId()!=0){
                    WHERE(" id=#{id}");
                    }
                    if (employee.getLoginname()!=null) {
                        WHERE(" loginname=#{loginname}");
                    }
                    if (employee.getPassword() != null) {
                        WHERE(" password=#{password}");
                    }
                    if (employee.getAge()!=0){
                        WHERE(" age=#{age}");
                    }
                    if (employee.getSex() != null) {
                        WHERE(" sex=#{sex}");
                    }
                    if (employee.getPhone() != null) {
                        WHERE(" phone=#{phone}");
                    }
                    if (employee.getSalary()!=0){
                        WHERE(" Salary=#{salary}");
                    }
                    WHERE("id=#{id}");
                }
            }.toString();
        }
}
