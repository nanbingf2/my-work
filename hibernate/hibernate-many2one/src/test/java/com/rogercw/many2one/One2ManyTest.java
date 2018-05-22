package com.rogercw.many2one;

import com.rogercw.dao.PublishersDao;
import com.rogercw.domain.Books;
import com.rogercw.domain.Publishers;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by 1 on 2018/5/12.
 *
 */
public class One2ManyTest {

    private PublishersDao publisherDao=new PublishersDao();

    /**
     * 单向一对多测试
     */
    @Test
    public void one2ManyTest() {
        Publishers publisher= (Publishers) publisherDao.get(Publishers.class,1);
        assertNotNull(publisher);
        for (Books book:publisher.getBooks()){
            System.out.println(book.getTitle());
        }
       /* publisher.getBooks().stream()
                .map(book-> System.out.println(book.getTitle()));*/
    }
}
