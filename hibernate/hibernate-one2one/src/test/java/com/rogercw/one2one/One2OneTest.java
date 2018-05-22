package com.rogercw.one2one;

import com.rogercw.dao.IdentityCardDao;
import com.rogercw.dao.PeopleDao;
import com.rogercw.domain.IdentityCard;
import com.rogercw.domain.People;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/14.
 */
public class One2OneTest {

    private PeopleDao peopleDao=new PeopleDao();
    private IdentityCardDao identityCardDao=new IdentityCardDao();

    @Test
    public void getPeopleTest() {
        People people= (People) peopleDao.get(People.class,2);
        assertNotNull(people);
        assertEquals(people.getIdentityCard().getId(),2);
    }

    @Test
    public void getIdentityCardTest() {
        IdentityCard identityCard= (IdentityCard) identityCardDao.get(IdentityCard.class,2);
        assertNotNull(identityCard);
        assertEquals(identityCard.getPeople().getName(),"lisi");
    }

    @Test
    public void addPeopleTest() {
        People people=new People();
        IdentityCard identityCard=new IdentityCard();
        identityCard.setCardidNo("00005");
        people.setName("jerry");
        people.setAge(17);
        people.setSex("女");
        //设置相互关联
        people.setIdentityCard(identityCard);
        identityCard.setPeople(people);
        peopleDao.add(people);
    }

    @Test
    public void deletePeopleTest() {
        People people= (People) peopleDao.get(People.class,2);
        peopleDao.delete(people);
    }
}
