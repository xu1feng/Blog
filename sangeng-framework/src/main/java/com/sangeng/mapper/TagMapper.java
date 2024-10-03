package com.sangeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangeng.domain.entity.Tag;
import org.apache.ibatis.annotations.Param;

/**
 * 标签(Tag)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-28 21:55:13
 */
public interface TagMapper extends BaseMapper<Tag> {
    int myUpdateById(@Param("id") Long id, @Param("flag") int flag);
}

