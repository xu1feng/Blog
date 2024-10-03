package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sangeng.constants.SystemCanstants;
import com.sangeng.domain.entity.LoginUser;
import com.sangeng.domain.entity.User;
import com.sangeng.mapper.MenuMapper;
import com.sangeng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/9/23
 **/

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(queryWrapper);

        // 判断是否查到用户  如果没查到，抛出异常
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }

        // 返回用户信息
        // TODO 查询权限信息封装
        // TODO 如果是后台用户才需要查询权限封装
        if (user.getType().equals(SystemCanstants.ADMIN)) {
            List<String> list = menuMapper.selectPermsByOtherUserId(user.getId());
            return new LoginUser(user, list);
        }
        return new LoginUser(user, null);
    }
}
