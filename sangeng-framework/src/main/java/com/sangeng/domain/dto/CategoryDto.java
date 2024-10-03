package com.sangeng.domain.dto;

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
public class CategoryDto {

    //分类名
    private String name;
    //描述
    private String description;
    //状态0:正常,1禁用
    private String status;

}
