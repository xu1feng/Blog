package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.vo.CategoryVo;
import com.sangeng.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/

@RestController
@RequestMapping("/content/category")
public class CategoryController {

    //--------------------------写博文——查询文章分类接口--------------------------

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory() {
        List<CategoryVo> categoryVos = categoryService.listAllCategory();
        return ResponseResult.okResult(categoryVos);
    }
}
