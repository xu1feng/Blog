package com.sangeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.User;
import com.sangeng.domain.vo.UserInfoVo;
import com.sangeng.mapper.UserMapper;
import com.sangeng.service.UserService;
import com.sangeng.utils.BeanCopyUtils;
import com.sangeng.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2024-09-25 20:11:20
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public ResponseResult userInfo() {
        // 获取当前用户id
        Long userId = SecurityUtils.getUserId();

        // 根据用户id查询用户信息
        User user = getById(userId);

        // 封装成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        return ResponseResult.okResult(userInfoVo);
    }

    @Override
    public ResponseResult updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }
}
