package com.rogercw.dao;

import com.rogercw.domain.User;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 1 on 2018/4/4.
 */
public interface UserDao {

    /**
     * 根据用户名和密码查找匹配的用户个数
     * @param userName
     * @param password
     * @return
     */
    public int getMatchCount(String userName, String password);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName);

    /**
     * 更新用户登录信息
     * @param user
     */
    public void updateUserLoginInfo(User user);
}
