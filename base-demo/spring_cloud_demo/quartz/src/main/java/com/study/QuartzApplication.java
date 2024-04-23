package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @类名称:QuartzApplication
 * @类描述:启动类
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-15
 * @版本:V1.0.0
 */
@SpringBootApplication
@MapperScan("com.study.mapper")
public class QuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class);
    }
}