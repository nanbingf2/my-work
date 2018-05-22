package com.rogercw.mapper;

import com.rogercw.domain.Card;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 1 on 2018/5/21.
 */
public interface CardMapper {

    @Select("SELECT * FROM t_card WHERE id=#{id}")
    public Card selectCardById(int id);
}
