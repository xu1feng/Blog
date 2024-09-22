package com.sangeng.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/9/22
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListVo {

    private Long id;

    //标题
    private String title;

    //文章摘要
    private String summary;

    //所属分类名
    private Long categoryName;

    //缩略图
    private String thumbnail;

    //访问量
    private Long viewCount;

    private Date createTime;
}
