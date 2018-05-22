package com.rogercw.mapper;

import com.rogercw.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 1 on 2018/5/21.
 */
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE id=#{id}")
    public User selectUserById(int id);
}
