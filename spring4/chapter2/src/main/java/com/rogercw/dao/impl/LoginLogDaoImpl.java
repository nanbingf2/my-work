package com.rogercw.dao.impl;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.rogercw.dao.LoginLogDao;
import com.rogercw.domain.LoginLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 1 on 2018/4/4.
 */
@Repository
public class LoginLogDaoImpl implements LoginLogDao{

    @Resource
    private JdbcTemplate jdbcTemplate;
    private final static String INSERT_LOGINLOG_SQL="INSERT INTO t_login_log(user_id,ip,login_datetime)" +
            " VALUES(?,?,?)";

    @Override
    public void insertLoginLog(LoginLog loginLog) {
        jdbcTemplate.update(INSERT_LOGINLOG_SQL,
                new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()});
    }

    //**************************************************************

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
