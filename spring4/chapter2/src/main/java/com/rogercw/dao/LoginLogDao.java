package com.rogercw.dao;

import com.rogercw.domain.LoginLog;
import org.springframework.stereotype.Repository;

/**
 * Created by 1 on 2018/4/4.
 */
public interface LoginLogDao {

    public void insertLoginLog(LoginLog loginLog);
}
