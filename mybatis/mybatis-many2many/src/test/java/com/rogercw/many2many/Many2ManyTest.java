package com.rogercw.many2many;

import com.rogercw.SqlSessionFactoryUtils;
import com.rogercw.domain.Order;
import com.rogercw.domain.User;
import com.rogercw.mapper.OrderMapper;
import com.rogercw.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/20.
 */
public class Many2ManyTest {

    @Test
    public void selectUserByIdTest() {
        SqlSession session= SqlSessionFactoryUtils.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.selectUserById(1);
        System.out.println(user.getLoginname());
        user.getOrders().forEach(order->
                System.out.println(order.getCode()));
    }


    @Test
    public void selectOrderByIdTest() {
        SqlSession session=SqlSessionFactoryUtils.openSession();
        OrderMapper orderMapper=session.getMapper(OrderMapper.class);
        Order order=orderMapper.selectOrderById(2);
        System.out.println(order.getCode());
        order.getArticles().forEach(article->
                System.out.println(article.getName()));
    }
}
