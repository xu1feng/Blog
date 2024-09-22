package com.sangeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 博客的启动类
 * @Author: 徐一峰
 * @Date: 2024/9/22
 **/

@SpringBootApplication
@MapperScan("com.sangeng.mapper")
public class SanGengBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(SanGengBlogApplication.class, args);
    }
}
