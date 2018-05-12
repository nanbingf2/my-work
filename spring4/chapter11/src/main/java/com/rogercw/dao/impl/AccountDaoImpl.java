package com.rogercw.dao.impl;

import com.rogercw.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 1 on 2018/5/5.
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void in(String inner, int money) {
        jdbcTemplate.update("update account set money=money + ? where username = ?",money,inner);
    }

    public void out(String outer, int money) {
        jdbcTemplate.update("update account set money=money-? where username=?",money,outer);
    }
}
