package com.rogercw.service.impl;

import com.rogercw.dao.AccountDao;
import com.rogercw.service.AccountService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 1 on 2018/5/5.
 */
@Transactional
public class AnnotatioAccountService implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void transfer(String outer, String inner, int money) {
        accountDao.out(outer,money);
        int i=1/0;
        accountDao.in(inner,money);
    }
}
