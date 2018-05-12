package com.rogercw.service.impl;

import com.rogercw.dao.UserDao;
import com.rogercw.domain.User;
import com.rogercw.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 1 on 2018/5/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(int uId) {
        return userDao.getUserById(uId);
    }

    @Override
    public void delete(int uId) {
        userDao.delete(uId);
    }

    @Override
    public boolean getUserByUsernameAndPassword(String username,String password) {
        return userDao.getUserByUsernameAndPassword(username,password);
    }
}
