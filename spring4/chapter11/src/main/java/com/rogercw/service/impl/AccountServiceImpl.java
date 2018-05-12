package com.rogercw.service.impl;

import com.rogercw.dao.AccountDao;
import com.rogercw.service.AccountService;

import javax.annotation.Resource;

/**
 * Created by 1 on 2018/5/5.
 */
public class AccountServiceImpl implements AccountService{

    @Resource
    private AccountDao accountDao;

    @Override
    public void transfer(String outer, String inner, int money) {
        accountDao.out(outer,money);
        int i=1/0;
        accountDao.in(inner,money);
        System.out.println("转账成功");
    }
}
