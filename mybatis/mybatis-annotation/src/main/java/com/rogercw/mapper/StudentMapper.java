package com.rogercw.mapper;

import com.rogercw.domain.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 1 on 2018/5/21.
 */
public interface StudentMapper {

    @Select("SELECT * FROM t_student WHERE class_id=#{id}")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(property = "sex",column = "sex"),
        @Result(property = "name",column = "name"),
        @Result(property = "age",column = "age")
    })
    public List<Student> selectStudentByClassId(int id);

}
