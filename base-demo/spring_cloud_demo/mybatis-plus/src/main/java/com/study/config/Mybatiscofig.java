package com.study.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @类名称:Mybatiscofig
 * @类描述:
 * @包名:com.study.config
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-19
 * @版本:V1.0.0
 */
@Configuration
@MapperScan("com.study.mapper")
public class Mybatiscofig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

  /*  *//**
     * 注入拦截器
     *
     * @return
     *//*
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }
*/
    /**
     * 乐观锁插件注入
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
