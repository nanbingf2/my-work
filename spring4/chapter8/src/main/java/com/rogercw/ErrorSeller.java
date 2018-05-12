package com.rogercw;

/**
 * Created by 1 on 2018/5/5.
 */
public class ErrorSeller implements Seller{
    @Override
    public int seller(String good) {
        return 0;
    }

    @Override
    public void server(String name) {
        throw new IllegalArgumentException("参数错误");
    }
}
