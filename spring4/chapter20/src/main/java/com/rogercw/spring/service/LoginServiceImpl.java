package com.rogercw.spring.service;

import org.springframework.stereotype.Service;

/**
 * Created by 1 on 2018/5/11.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(String username, String password) {
        if(username=="zhangsan"&&password=="1234"){
            return true;
        }else{
            return false;
        }
    }
}
