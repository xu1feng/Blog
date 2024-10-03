package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2024-09-25 20:11:19
 */
public interface UserService extends IService<User> {
    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);

    //查询用户列表
    ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize);

    //增加用户-②新增用户
    boolean checkUserNameUnique(String userName);
    boolean checkPhoneUnique(User user);
    boolean checkEmailUnique(User user);
    ResponseResult addUser(User user);

    //修改用户-②更新用户信息
    void updateUser(User user);
}
