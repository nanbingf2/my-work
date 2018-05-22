package com.rogercw.mapper;

import com.rogercw.domain.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by 1 on 2018/5/21.
 */
public interface OrderMapper {

    @Select("SELECT * FROM t_order WHERE id=#{id}")
    @Results({
        @Result(id = true,column = "id",property = "id"),
            @Result(property = "code",column = "code"),
            @Result(column = "total",property = "total"),
            /*配置多对一关联映射*/
            @Result(column ="user_id", property = "user",
            one = @One(select = "com.rogercw.mapper.UserMapper.selectUserById",
            fetchType = FetchType.EAGER)),

            /*配置多对多关联映射*/
            @Result(column = "id",property = "articles",
            many = @Many(select = "com.rogercw.mapper.ArticleMapper.selectArticleByOrderId",
                        fetchType = FetchType.LAZY
            ))
    })
    public Order selectOrderById(int id);
}
