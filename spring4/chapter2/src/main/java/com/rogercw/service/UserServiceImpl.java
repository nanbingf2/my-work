package com.rogercw.service;

import com.rogercw.dao.LoginLogDao;
import com.rogercw.dao.UserDao;
import com.rogercw.domain.LoginLog;
import com.rogercw.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 1 on 2018/4/4.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private LoginLogDao loginLogDao;

    @Override
    public boolean hasMatchUser(String userName, String password) {
        int count=userDao.getMatchCount(userName,password);
        return count>0;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional//开启事物注解
    @Override
    public void loginSuccess(User user) {
        user.setCredits(5+user.getCredits());
        LoginLog loginLog=new LoginLog();
        loginLog.setIp(user.getLastIp());
        loginLog.setUserId(user.getUserId());
        loginLog.setLoginDate(user.getLastLogin());
        //更新用户登录信息
        userDao.updateUserLoginInfo(user);
        //向日志表中插入登录日志信息
        loginLogDao.insertLoginLog(loginLog);
    }

    //***********************************************************

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }
}
