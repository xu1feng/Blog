package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Role;
import com.sangeng.domain.entity.User;
import com.sangeng.domain.vo.UserInfoAndRoleIdsVo;
import com.sangeng.enums.AppHttpCodeEnum;
import com.sangeng.exception.SystemException;
import com.sangeng.service.RoleService;
import com.sangeng.service.UserService;
import com.sangeng.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    //--------------------------------查询用户列表-------------------------------------

    @GetMapping("/list")
    public ResponseResult list(User user, Integer pageNum, Integer pageSize) {
        return userService.selectUserPage(user,pageNum,pageSize);
    }

    @PostMapping
    public ResponseResult add(@RequestBody User user) {
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        if (!userService.checkUserNameUnique(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (!userService.checkPhoneUnique(user)){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }
        if (!userService.checkEmailUnique(user)){
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        return userService.addUser(user);
    }

    //--------------------------------删除用户--------------------------------------

    @DeleteMapping("/{userIds}")
    public ResponseResult remove(@PathVariable List<Long> userIds) {
        if(userIds.contains(SecurityUtils.getUserId())){
            return ResponseResult.errorResult(500,"不能删除当前你正在使用的用户");
        }
        userService.removeByIds(userIds);
        return ResponseResult.okResult();
    }

    //-----------------------修改用户-①根据id查询用户信息-----------------------------

    @Autowired
    private RoleService roleService;

    @GetMapping(value = { "/{userId}" })
    public ResponseResult getUserInfoAndRoleIds(@PathVariable(value = "userId") Long userId) {
        List<Role> roles = roleService.selectRoleAll();
        User user = userService.getById(userId);
        //当前用户所具有的角色id列表
        List<Long> roleIds = roleService.selectRoleIdByUserId(userId);

        UserInfoAndRoleIdsVo vo = new UserInfoAndRoleIdsVo(user,roles,roleIds);
        return ResponseResult.okResult(vo);
    }

    //-------------------------修改用户-②更新用户信息--------------------------------

    @PutMapping
    public ResponseResult edit(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseResult.okResult();
    }
}
