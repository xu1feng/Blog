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
public class ChangeUserStatusDto {
    private Long userId;
    private String status;
}