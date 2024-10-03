package com.sangeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.domain.vo.ArticleVo;
import com.sangeng.mapper.ArticleVoMapper;
import com.sangeng.service.ArticleVoService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/
@Service
public class ArticleVoServiceImpl extends ServiceImpl<ArticleVoMapper, ArticleVo> implements ArticleVoService {
}
