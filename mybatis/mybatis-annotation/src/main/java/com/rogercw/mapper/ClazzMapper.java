package com.rogercw.mapper;

import com.rogercw.domain.Clazz;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by 1 on 2018/5/21.
 */
public interface ClazzMapper {

    @Select("SELECT * FROM t_class WHERE id=#{id}")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "id",property = "id"),
        @Result(column = "code",property = "code"),
        @Result(column = "name",property = "name"),
        @Result(column = "id",property = "students",
                many = @Many(
                        select = "com.rogercw.mapper.StudentMapper.selectStudentByClassId",
                        fetchType = FetchType.LAZY))
    })
    public Clazz selectClazzById(int id);
}
