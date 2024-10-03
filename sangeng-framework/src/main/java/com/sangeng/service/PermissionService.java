package com.sangeng.service;

import com.sangeng.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/

@Service("ps")
public class PermissionService {

    /**
     * 判断当前用户是否具有permission
     * @param permission 要判断的权限
     * @return
     */
    public boolean hasPermission(String permission) {
        // 如果是超级管理员 直接返回true
        if (SecurityUtils.isAdmin()) {
            return true;
        }
        // 否则 获取当前登录用户所具有的权限列表 然后判断是否存在permission
        List<String> permissions = SecurityUtils.getLoginUser().getPermissions();
        return permissions.contains(permission);
    }
}
