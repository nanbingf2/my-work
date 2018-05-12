package com.rogercw.service.impl;

import com.rogercw.dao.PersonDao;
import com.rogercw.domain.Person;

/**
 * Created by 1 on 2018/5/11.
 */
public class PersonServiceImpl {

    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(int id,String name){
        Person person=personDao.findPersonById(id);
        if(person!=null){
            person.setName(name);
            return personDao.update(person);
        }else{
            return false;
        }
    }
}
