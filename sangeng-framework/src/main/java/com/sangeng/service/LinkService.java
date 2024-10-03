package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Link;
import com.sangeng.domain.vo.PageVo;

/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2024-09-23 20:01:22
 */
public interface LinkService extends IService<Link> {
    ResponseResult getAllLink();

    //分页查询友链
    PageVo selectLinkPage(Link link, Integer pageNum, Integer pageSize);

}
