package com.sangeng.domain.vo;

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
public class TagVo {

    private Long id;
    private String name;
    private String remark;
}
