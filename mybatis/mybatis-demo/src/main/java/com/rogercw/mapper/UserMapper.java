package com.rogercw.mapper;

import com.rogercw.domain.User;

import java.util.List;

/**
 * Created by 1 on 2018/5/18.
 */
public interface UserMapper {

    public User findById(int id);
    public int insertUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public int findUserTotal();
    public User selectResultMap(int id);
}
