package com.rogercw.mapper;

import com.rogercw.domain.Article;

/**
 * Created by 1 on 2018/5/20.
 */
public interface ArticleMapper {

    public Article selectArticleByOrderId(int order_id);
}
