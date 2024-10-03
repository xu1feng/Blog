package com.sangeng.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user_role")
public class UserRole {

    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;
}
