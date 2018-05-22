package com.rogercw.batch;

import com.rogercw.dao.UserDao;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/15.
 */
public class BatchTest {

    private UserDao userDao=new UserDao();

    @Test
    public void batchAddTest() {
        long beginTime=System.currentTimeMillis();
        userDao.batchAddUser();
        System.out.println(beginTime-System.currentTimeMillis());
    }

    @Test
    public void batchUpdateTest() {
        long beginTime=System.currentTimeMillis();
        userDao.batchUpdateUser();
        System.out.println(beginTime-System.currentTimeMillis());
    }

    @Test
    public void batchDeleteTest() {
        long beginTime=System.currentTimeMillis();
        userDao.batchDeleteUser();
        System.out.println(beginTime-System.currentTimeMillis());
    }
}
