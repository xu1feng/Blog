package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleLIst();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);
}
