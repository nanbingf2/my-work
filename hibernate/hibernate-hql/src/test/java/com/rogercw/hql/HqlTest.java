package com.rogercw.hql;

import com.rogercw.dao.BookDao;
import com.rogercw.entity.Books;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by 1 on 2018/5/15.
 */
public class HqlTest {

    private BookDao bookDao =new BookDao();

    @Test
    public void pageTest() {
        List<Books> books = bookDao.findPage(1, 4);
        assertEquals(books.size(),4);
    }

    @Test
    public void test() {
        bookDao.test();
        bookDao.groupTest();
    }

    @Test
    public void findByTitle() {
        Books book = bookDao.findByTitle("Java");
        assertEquals(book.getTitle(),"Java");
    }

    @Test
    public void findAll() {
        List<Books> list1 = bookDao.findAll();
        List<Books> list2= bookDao.findAllAndSorted();
        assertEquals(list1.size(),list2.size());
    }
}
