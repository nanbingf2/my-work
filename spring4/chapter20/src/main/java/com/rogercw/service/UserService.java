package com.rogercw.service;

import com.rogercw.domain.User;

/**
 * Created by 1 on 2018/5/11.
 */
public interface UserService {

    public User getUserById(int uId);

    public void delete(int uId);

    public boolean getUserByUsernameAndPassword(String username,String password);
}
