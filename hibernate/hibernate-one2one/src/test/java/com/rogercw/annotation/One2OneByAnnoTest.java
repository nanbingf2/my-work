package com.rogercw.annotation;

import com.rogercw.dao.IdentityCardDao;
import com.rogercw.dao.PeopleDao;
import com.rogercw.domain.IdentityCard;
import com.rogercw.entity.Identitycard;
import com.rogercw.entity.People;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/14.
 */
public class One2OneByAnnoTest {

    private PeopleDao peopleDao=new PeopleDao();
    private IdentityCardDao identityCardDao=new IdentityCardDao();

    @Test
    public void getPeopleTest() {
        People people= (People) peopleDao.get(People.class,2);
        assertNotNull(people);
        assertEquals(people.getIdentityCard().getId(),2);
    }

    @Test
    public void addPeopleTest() {
        People people=new People();
        people.setName("Reus");
        people.setSex("男");
        people.setAge(24);

        Identitycard identityCard=new Identitycard();
        identityCard.setCardidNo("00008");
        people.setIdentityCard(identityCard);
        peopleDao.add(people);
    }

    @Test
    public void deleteIdentityCardTest() {
        Identitycard identitycard= (Identitycard) identityCardDao.get(Identitycard.class,5);
        identityCardDao.delete(identitycard);
    }
}
