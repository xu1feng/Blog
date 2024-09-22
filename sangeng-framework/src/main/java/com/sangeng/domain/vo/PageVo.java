package com.sangeng.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/9/22
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {

    private List rows;
    private Long total;
}
