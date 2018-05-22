package com.rogercw.many2one;

import com.rogercw.dao.BookDao;
import com.rogercw.domain.Books;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by 1 on 2018/5/12.
 */
public class Many2OneTest {

    private BookDao bookDao=new BookDao();

    /**
     * 單向多對一测试
     */
    @Test
    public void many2OneTest() {
        Books book= (Books) bookDao.get(Books.class,1);
        assertEquals(book.getTitle(),"Spring");
        //由于默认采用懒加载来加载关联的对象,
        // 当session关闭后再尝试获取关联对象时会抛出懒加载异常
        //因此需要修改lazy属性为false,下面这行语句才不会报错
        assertEquals(book.getPublisher().getName(),"上海出版社");
    }
}
