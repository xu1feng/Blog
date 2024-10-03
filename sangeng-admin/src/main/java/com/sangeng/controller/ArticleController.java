package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.dto.AddArticleDto;
import com.sangeng.domain.dto.ArticleDto;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.vo.ArticleByIdVo;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/

@RestController
@RequestMapping("/content/article")
public class ArticleController {

    //-------------------------新增博客文章-------------------------

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto articleDto) {
        return articleService.add(articleDto);
    }

    //-------------------------分页查询博客文章-------------------------

    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize) {
        PageVo pageVo = articleService.selectArticlePage(article, pageNum, pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------根据文章id修改文章-------------------------

    @GetMapping("/{id}")
    public ResponseResult getInfo(@PathVariable("id") Long id) {
        ArticleByIdVo article = articleService.getInfo(id);
        return ResponseResult.okResult(article);
    }

    @PutMapping
    public ResponseResult edit(@RequestBody ArticleDto articleDto) {
        articleService.edit(articleDto);
        return ResponseResult.okResult();
    }

    //-------------------------根据文章id删除文章-------------------------

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        articleService.removeById(id);
        return ResponseResult.okResult();
    }
}
