package com.rogercw.many2one;

import com.rogercw.dao.BookDao;
import com.rogercw.dao.PublishersDao;
import com.rogercw.domain.Books;
import com.rogercw.domain.Publishers;
import org.junit.Test;

import java.util.Date;

/**
 * Created by 1 on 2018/5/12.
 */
public class Many2OneDoubleTest {

    private PublishersDao publisherDao=new PublishersDao();
    private BookDao bookDao=new BookDao();

    /**
     * 添加出版社测试
     */
    @Test
    public void addPublisherTest() {
        Publishers publisher=new Publishers();
        publisher.setName("电子工业出版社");
        publisherDao.add(publisher);
    }

    @Test
    public void addBooksTest() {
        //查询出版社对象
        Publishers publisher= (Publishers) publisherDao.get(Publishers.class,4);
        //创建对象并设置值和关联对象
        Books book=new Books();
        book.setTitle("Hibernate");
        book.setAuthor("zhangsan");
        book.setPublisher(publisher);
        book.setPublishDate(new Date());
        book.setPrice(65.00);
        //保存
        bookDao.add(book);
    }

    /**
     * 级联添加操作:由多的一方管理关联关系
     */
    @Test
    public void cascadeAddTest() {
        Publishers publisher=new Publishers();
        publisher.setName("清华大学出版社");

        Books book=new Books();
        book.setTitle("Java");
        book.setAuthor("lisi");
        book.setPublisher(publisher);
        book.setPrice(70.00);
        //保存图书:由多的一方管理关联关系
        bookDao.add(book);
    }

    /**
     * 级联添加操作:由一的一方管理关联关系
     */
    @Test
    public void cascadeAddTest2() {
        Publishers publisher=new Publishers();
        publisher.setName("电子出版社");

        Books book=new Books();
        book.setTitle("Scala");
        book.setAuthor("jerry");
        book.setPrice(70.00);
        publisher.getBooks().add(book);

        //保存
        publisherDao.add(publisher);
    }

    @Test
    public void deleteFromMany(){
        //加载需要删除的对象
        Books book= (Books) bookDao.get(Books.class,15);
        //删除对象
        bookDao.delete(book);
    }

    @Test
    public void deleteFromOne() {
        Publishers publisher= (Publishers) publisherDao.get(Publishers.class,18);
        publisherDao.delete(publisher);
    }

}
