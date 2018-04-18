package com.rogercw.dao;

import com.rogercw.domain.User;

/**
 * Created by 1 on 2018/4/16.
 */
public interface UserDao {
    public int getMatchCount(String userName,String password);

    public User findUserByUserName(String userName);

    public void updateUserLoginInfo(User user);
}
