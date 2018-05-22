package com.rogercw.mapper;

import com.rogercw.domain.Order;

/**
 * Created by 1 on 2018/5/20.
 */
public interface OrderMapper {

    public Order selectOrderById(int id);

    public Order selectOrderByUserId(int id);
}
