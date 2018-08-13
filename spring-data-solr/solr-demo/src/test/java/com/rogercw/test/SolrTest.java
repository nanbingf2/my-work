package com.rogercw.test;

import com.rogercw.pojo.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Crotch;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/12 22:52
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-solr.xml")
public class SolrTest {

    @Autowired
    private SolrTemplate solrTemplate;

    //更新或者保存测试
    @Test
    public void saveTest(){
        //创建Item对象
        Item item=new Item();
        item.setId(1L);
        item.setTitle("联想电脑");
        item.setPrice(new BigDecimal(1020.00));
        item.setBrand("联想");
        item.setCategory("电脑");
        item.setGoodsId(1L);
       item.setSeller("联想专卖店");
       //保存到solr中
        solrTemplate.saveBean(item);
        //提交
        solrTemplate.commit();
    }


    //按主键查询
    @Test
    public void findOneTest(){
        Item item = solrTemplate.getById(1, Item.class);
        System.out.println(item);
    }


    //按主键删除
    @Test
    public void deleteTest(){
        solrTemplate.deleteById("1");
        solrTemplate.commit();
    }


    //循环插入数据
    @Test
    public void addListTest(){
        List<Item> itemList=new ArrayList<Item>();
        for (int i = 0; i < 100; i++) {
            Item item=new Item();
            item.setId(i+1L);
            item.setTitle("联想电脑"+i);
            item.setPrice(new BigDecimal(1020.00+i*10));
            item.setBrand("联想");
            item.setCategory("电脑");
            item.setGoodsId(i+1L);
            itemList.add(item);
        }
        solrTemplate.saveBeans(itemList);
        solrTemplate.commit();
    }

    //分页查询
    @Test
    public void pageQueryTest(){
        Query query=new SimpleQuery("*:*");
        //设置开始索引
        query.setOffset(20);
        //设置每页记录数
        query.setRows(20);
        ScoredPage<Item> pages = solrTemplate.queryForPage(query, Item.class);
        System.out.println("总记录数："+pages.getTotalElements());
        List<Item> items=pages.getContent();
        items.forEach(item->
            System.out.println(item));
    }


    //条件查询
    @Test
    public void conditionTest(){
        Query query=new SimpleQuery("*:*") ;
        //Criteria用于对查询条件的封装
        Criteria criteria=new Criteria("item_title").contains("2");
        criteria=criteria.and("item_title").contains("5");
        query.addCriteria(criteria);
        ScoredPage<Item> pages = solrTemplate.queryForPage(query, Item.class);
        //System.out.println("总记录数："+pages.getTotalElements());
        List<Item> items=pages.getContent();
        items.forEach(item->
                System.out.println(item));
    }


    //删除全部数据
    @Test
    public void deleteAllTest(){
        Query query=new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();
    }
}
