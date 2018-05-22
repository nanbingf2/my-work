package com.rogercw.annotation;

import com.rogercw.dao.BookDao;
import com.rogercw.dao.PublishersDao;
import com.rogercw.entity.Books;
import com.rogercw.entity.Publishers;
import org.junit.Test;

import java.util.Date;

/**
 * Created by 1 on 2018/5/14.
 * 该测试类用来测试基于注解配置的多对一关联映射
 */
public class Many2OneByAnnoTest {

    private BookDao bookDao=new BookDao();
    private PublishersDao publisherDao=new PublishersDao();

    @Test
    public void addBookTest() {
        Publishers publisher=new Publishers();
        publisher.setName("人民邮电出版社");

        Books book=new Books();
        book.setTitle("Linux基础");
        book.setPrice(36.00);
        book.setAuthor("herry");
        book.setPublishDate(new Date());
        book.setPublisher(publisher);

        bookDao.add(book);
    }

    @Test
    public void deleteBookTest() {
        Books book= (Books) bookDao.get(Books.class,4);
        bookDao.delete(book);
    }

    @Test
    public void deletePublisherTest() {
        Publishers publisher= (Publishers) publisherDao.get(Publishers.class,16);
        publisherDao.delete(publisher);
    }

    @Test
    public void updateTest() {
        Books book= (Books) bookDao.get(Books.class,10);
        Publishers publisher= (Publishers) publisherDao.get(Publishers.class,5);
        book.setPublisher(publisher);
        bookDao.update(book);
    }
}
