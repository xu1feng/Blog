package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.constants.SystemCanstants;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Role;
import com.sangeng.domain.entity.RoleMenu;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.mapper.RoleMapper;
import com.sangeng.service.RoleMenuService;
import com.sangeng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2024-09-30 11:32:01
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    //查询用户的角色信息
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员，如果是，就返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }

        //否则查询对应普通用户所具有的的角色信息
        List<String> otherRole = getBaseMapper().selectRoleKeyByOtherUserId(id);

        return otherRole;
    }

    @Override
    public ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.hasText(role.getRoleName()),Role::getRoleName,role.getRoleName());
        lambdaQueryWrapper.eq(StringUtils.hasText(role.getStatus()),Role::getStatus,role.getStatus());
        lambdaQueryWrapper.orderByAsc(Role::getRoleSort);

        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,lambdaQueryWrapper);

        //转换成VO
        List<Role> roles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(roles);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------新增角色----------------------------------------

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    @Transactional
    public void insertRole(Role role) {
        save(role);
        System.out.println(role.getId());
        if(role.getMenuIds()!=null&&role.getMenuIds().length>0){
            insertRoleMenu(role);
        }
    }

    private void insertRoleMenu(Role role) {
        List<RoleMenu> roleMenuList = Arrays.stream(role.getMenuIds())
                .map(memuId -> new RoleMenu(role.getId(), memuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenuList);
    }

    //-----------------------修改角色-保存修改好的角色信息----------------------------

    @Override
    public void updateRole(Role role) {
        updateById(role);
        roleMenuService.deleteRoleMenuByRoleId(role.getId());
        insertRoleMenu(role);
    }

    //-----------------------新增用户-①查询角色列表接口----------------------------

    @Override
    public List<Role> selectRoleAll() {
        return list(Wrappers.<Role>lambdaQuery().eq(Role::getStatus, SystemCanstants.NORMAL));
    }

    //-----------------------修改用户-①根据id查询用户信息----------------------------
    @Override
    public List<Long> selectRoleIdByUserId(Long userId) {
        return getBaseMapper().selectRoleIdByUserId(userId);
    }
}
