package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.dto.AddTagDto;
import com.sangeng.domain.dto.EditTagDto;
import com.sangeng.domain.dto.TagListDto;
import com.sangeng.domain.entity.Tag;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.service.TagService;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/9/28
 **/

@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        return tagService.pageTagList(pageNum, pageSize, tagListDto);
    }

    @PostMapping
    public ResponseResult add(@RequestBody AddTagDto addTagDto) {
        Tag tag = BeanCopyUtils.copyBean(addTagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id) {
        tagService.removeById(id);
        return ResponseResult.okResult();
    }

    @GetMapping("/{id}")
    public ResponseResult getInfo(@PathVariable Long id) {
        Tag tag = tagService.getById(id);
        return ResponseResult.okResult(tag);
    }

    @PutMapping
    public ResponseResult edit(@RequestBody EditTagDto editTagDto) {
        Tag tag = BeanCopyUtils.copyBean(editTagDto, Tag.class);
        tagService.updateById(tag);
        return ResponseResult.okResult();
    }
}
