package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @类名称:EsApplication
 * @类描述:
 * @包名:PACKAGE_NAME
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-16
 * @版本:V1.0.0
 */
@SpringBootApplication
@MapperScan("com.study.mapper")
public class EsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class);
    }
}
