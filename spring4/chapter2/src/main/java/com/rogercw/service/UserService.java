package com.rogercw.service;

import com.rogercw.domain.User;

/**
 * Created by 1 on 2018/4/4.
 */
public interface UserService {
    /**
     * 根据用户名和密码匹配用户
     * @param userName
     * @param password
     * @return
     */
    public boolean hasMatchUser(String userName, String password);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName);

    /**
     * 登录成功操作
     * @param user
     */
    public void loginSuccess(User user);
}
