package com.sangeng.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.dto.CategoryDto;
import com.sangeng.domain.entity.Category;
import com.sangeng.domain.vo.CategoryVo;
import com.sangeng.domain.vo.ExcelCategoryVo;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.enums.AppHttpCodeEnum;
import com.sangeng.service.CategoryService;
import com.sangeng.utils.BeanCopyUtils;
import com.sangeng.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
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

    //--------------------------分页查询分类列表--------------------------

    @GetMapping("/list")
    public ResponseResult list(Category category, Integer pageNum, Integer pageSize) {
        PageVo pageVo = categoryService.selectCategoryPage(category, pageNum, pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //--------------------------增加文章的分类--------------------------

    @PostMapping
    public ResponseResult add(@RequestBody CategoryDto categoryDto) {
        Category category = BeanCopyUtils.copyBean(categoryDto, Category.class);
        categoryService.save(category);
        return ResponseResult.okResult();
    }

    //--------------------------删除文章的分类--------------------------

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        categoryService.removeById(id);
        return ResponseResult.okResult();
    }

    //--------------------------修改文章的分类--------------------------

    @GetMapping("/{id}")
    public ResponseResult getInfo(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        return ResponseResult.okResult(category);
    }

    @PutMapping
    public ResponseResult edit(@RequestBody Category category) {
        categoryService.updateById(category);
        return ResponseResult.okResult();
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        // 设置下载文件的请求头
        try {
            WebUtils.setDownLoadHeader("分类.xlsx", response);
            // 获取需要导出的数据
            List<Category> categories = categoryService.list();

            List<ExcelCategoryVo> excelCategoryVos = BeanCopyUtils.copyBeanList(categories, ExcelCategoryVo.class);

            // 把数据写入到Excel中
            EasyExcel.write(response.getOutputStream(), ExcelCategoryVo.class).autoCloseStream(Boolean.FALSE).sheet("分类导出")
                    .doWrite(excelCategoryVos);
        } catch (Exception e) {
            e.printStackTrace();
            // 如果出现异常也要响应json数据
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            //WebUtils是我们在huanf-framework工程写的类，里面的renderString方法是将json字符串写入到请求体，然后返回给前端
            WebUtils.renderString(response, JSON.toJSONString(result));
        }
    }
}
