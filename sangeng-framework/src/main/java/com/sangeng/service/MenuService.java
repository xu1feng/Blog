package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.entity.Menu;

import java.util.List;

/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2024-09-30 11:25:58
 */
public interface MenuService extends IService<Menu> {
    List<String> selectPermsByUserId(Long id);
}
