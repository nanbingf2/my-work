package com.rogercw.dao.impl;

import com.rogercw.dao.UserDao;
import com.rogercw.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 1 on 2018/4/16.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    private final static String MATCH_COUNT_SQL="SELECT COUNT(*) FROM t_user WHERE user_name=?" +
            " AND password=? ";
    private final static String UPDATE_USER_LOGININFO_SQL="UPDATE t_user SET credits=?" +
            ",last_visit=?,last_ip=? WHERE user_id=?";
    private final static String FINDBY_USERNAME_SQL="SELECT * FROM t_user WHERE" +
            " user_name=? ";


    @Override
    public int getMatchCount(String userName, String password) {
        Integer count = jdbcTemplate
                .queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
        return count;
    }

    @Override
    public User findUserByUserName(final String userName) {
        final User user=new User();
        jdbcTemplate.query(FINDBY_USERNAME_SQL, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    @Override
    public void updateUserLoginInfo(User user) {
        Object[] params=new Object[]{user.getCredits(),user.getLastLogin(),user.getLastIp(),user.getUserId()};
        jdbcTemplate.update(UPDATE_USER_LOGININFO_SQL,params);
    }

    //***********************************************************************

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
