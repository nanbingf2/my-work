package com.rogercw.mapper;

import com.rogercw.domain.Person;

/**
 * Created by 1 on 2018/5/18.
 */
public interface PersonMapper {

    public Person selectPersonById(int id);
}
