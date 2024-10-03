package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.dto.AddArticleDto;
import com.sangeng.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleLIst();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long articleId);

    ResponseResult updateViewCount(Long articleId);

    //新增博客文章
    ResponseResult add(AddArticleDto article);
}
