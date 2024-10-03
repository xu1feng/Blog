package com.sangeng.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelCategoryVo {

    @ExcelProperty("分类名")
    private String name;
    @ExcelProperty("描述")
    private String description;
    @ExcelProperty("状态0：正常，1：禁用")
    private String status;
}
