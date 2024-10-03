package com.sangeng.domain.vo;

import com.sangeng.domain.entity.Role;
import com.sangeng.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAndRoleIdsVo {
    private User user;
    private List<Role> roles;
    private List<Long> roleIds;
}
