package com.rogercw.dao;

import com.rogercw.domain.Person;

/**
 * Created by 1 on 2018/5/11.
 */
public interface PersonDao {
    public  Person findPersonById(int id);

    public boolean update(Person person);
}
