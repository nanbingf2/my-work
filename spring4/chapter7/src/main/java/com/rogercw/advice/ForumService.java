package com.rogercw.advice;

import java.sql.SQLException;

/**
 * Created by 1 on 2018/4/30.
 */
public class ForumService {

    public void removeForum(){
        throw new RuntimeException("出现运行时异常,删除失败");
    }

    public void createForum() throws SQLException {
        throw new SQLException("出现SQL异常,插入失败");
    }
}
