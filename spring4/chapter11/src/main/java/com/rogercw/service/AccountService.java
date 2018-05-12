package com.rogercw.service;

/**
 * Created by 1 on 2018/5/5.
 */
public interface AccountService {

    /**
     * 转账操作
     * @param outer
     * @param inner
     * @param money
     */
    public void transfer(String outer,String inner,int money);

}
