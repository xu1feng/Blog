package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.dto.AddArticleDto;
import com.sangeng.domain.dto.ArticleDto;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.vo.ArticleByIdVo;
import com.sangeng.domain.vo.PageVo;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleLIst();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long articleId);

    ResponseResult updateViewCount(Long articleId);

    //新增博客文章
    ResponseResult add(AddArticleDto article);

    // 管理后台（文章管理）-分页查询文章
    PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize);

    // 修改文章
    ArticleByIdVo getInfo(Long id);

    void edit(ArticleDto articleDto);
}
