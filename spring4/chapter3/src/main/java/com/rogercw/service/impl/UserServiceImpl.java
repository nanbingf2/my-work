package com.rogercw.service.impl;

import com.rogercw.dao.LoginLogDao;
import com.rogercw.dao.UserDao;
import com.rogercw.domain.LoginLog;
import com.rogercw.domain.User;
import com.rogercw.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by 1 on 2018/4/16.
 */
@Service
public class UserServiceImpl implements UserService{

    //注入UserDao
    @Resource
    private UserDao userDaoImpl;
    //注入LoginLogDao
    @Resource
    private LoginLogDao loginLogDaoImpl;

    @Override
    public boolean hasUserMatch(String userName, String password) {
        int count=userDaoImpl.getMatchCount(userName,password);
        return count>0 ? true : false;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userDaoImpl.findUserByUserName(userName);
    }

    @Transactional
    @Override
    public void loginSuccess(User user) {
        //登录成功,积分加五分
        user.setCredits(user.getCredits()+5);
        LoginLog loginLog=new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(new Date());
        //更新用户登录信息
        userDaoImpl.updateUserLoginInfo(user);
        //插入日志信息
        loginLogDaoImpl.insertLoginLog(loginLog);

    }

    public void setUserDaoImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public void setLoginLogDaoImpl(LoginLogDao loginLogDaoImpl) {
        this.loginLogDaoImpl = loginLogDaoImpl;
    }
}
