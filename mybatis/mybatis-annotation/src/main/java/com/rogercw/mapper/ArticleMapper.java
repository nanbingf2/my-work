package com.rogercw.mapper;

import com.rogercw.domain.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 1 on 2018/5/21.
 */
public interface ArticleMapper {

    @Select("SELECT * FROM t_article a,t_item i WHERE a.id=i.article_id" +
            " AND i.order_id=#{id}")
    public List<Article> selectArticleByOrderId(int id);
}
