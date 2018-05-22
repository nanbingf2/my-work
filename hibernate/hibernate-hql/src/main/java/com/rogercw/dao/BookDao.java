package com.rogercw.dao;

import com.rogercw.HibernateSessionFactory;
import com.rogercw.entity.Books;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 1 on 2018/5/15.
 */
public class BookDao {

    /**
     * 查询所有书籍
     * @return
     */
    public List<Books> findAll(){
        Session session= HibernateSessionFactory.openSession();
        String hql="FROM Books";
        Query query=session.createQuery(hql);
        List<Books> books=query.list();
        return books;
    }

    /**
     * 查询所有书籍并排序
     * @return
     */
    public List<Books> findAllAndSorted(){
        Session session= HibernateSessionFactory.openSession();
        String hql="from Books order by price desc";
        return session.createQuery(hql).list();
    }

    public List findAllBooksNameAndPrice(){
        Session session= HibernateSessionFactory.openSession();
        String hql="select title,price from Books";
        Query query=session.createQuery(hql);
        return query.list();
    }

    /**
     * 查询书的部分属性
     */
    public void test(){
        Session session=HibernateSessionFactory.openSession();
        String hql="select count(*) from Books";
        Query query=session.createQuery(hql);
        Long count= (Long) query.uniqueResult();

        String hql2="select min(price),max(price) from Books";
        Query query2=session.createQuery(hql2);
        Object[] price= (Object[]) query2.uniqueResult();

        System.out.println("书的总数为:"+count);
        System.out.println("书价最高为:"+price[1]+"..书价最低为:"+price[0]);
    }

    /**
     * 分组查询
     */
    public void groupTest() {
        Session session = HibernateSessionFactory.openSession();
        String hql = "select publisher.name,count(*) from Books group by publisher";
        Query query = session.createQuery(hql);
        List list = query.list();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object[] result = (Object[]) iterator.next();
            System.out.println("出版社名称:" + result[0] + "..出版的书数量为:" + result[1]);
        }
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public List<Books> findPage(int page,int size){
        Session session=HibernateSessionFactory.openSession();
        String hql="from Books order by price";
        Query query=session.createQuery(hql);
        query.setFirstResult((page-1)*size);
        query.setMaxResults(size);
        return query.list();
    }

    public List findByCondition(String condition){
        Session session=HibernateSessionFactory.openSession();
        String hql="from Books where title like ?";
        Query query=session.createQuery(hql);
        query.setParameter(0,condition);
        return query.list();
    }

    public Books findByTitle(String title){
        Session session=HibernateSessionFactory.openSession();
        String hql="from Books where title = :bookTitle";
        Query query=session.createQuery(hql);
        query.setParameter("bookTitle",title);
        return (Books) query.uniqueResult();
    }


}
