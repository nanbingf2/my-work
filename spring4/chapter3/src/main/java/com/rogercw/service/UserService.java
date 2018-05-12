package com.rogercw.service;

import com.rogercw.domain.User;

/**
 * Created by 1 on 2018/4/16.
 */
public interface UserService {
    /**
     * 根据用户名和密码查找是否有匹配的用户
     * @param userName
     * @param password
     */
    public boolean hasUserMatch(String userName,String password);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName);

    /**
     * 用户登录成功处理
     * @param user
     */
    public void loginSuccess(User user);

}
