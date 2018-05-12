package com.rogercw.dao.impl;

import com.rogercw.dao.UserDao;
import com.rogercw.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 1 on 2018/5/11.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(int uId) {
        return null;
    }

    @Override
    public boolean getUserByUsernameAndPassword(String username, String password) {
        return true;
    }

    @Override
    public void delete(int uId) {

    }
}
