package com.rogercw.mapper;

import com.rogercw.domain.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by 1 on 2018/5/21.
 */
public interface PersonMapper {

    @Select("SELECT * FROM t_person WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age"),
            @Result(property = "sex",column = "age"),
            @Result(property = "card",column = "card_id",
                    one = @One(select = "com.rogercw.mapper.CardMapper.selectCardById",
                    fetchType = FetchType.EAGER))
    })
    public Person selectPersonById(int id);

}
