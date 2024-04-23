
package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;


/**
 * @类名称:SwaggerConfig
 * @类描述:
 * @包名:com.study.config
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-18
 * @版本:V1.0.0
 */

@Configuration
public class SwaggerConfig {
    // 初始化Contact,配置的是作者的信息
    public static final Contact DEFAULT_CONTACT = new Contact("WangXinWei", "www.baidu.com", "2284562951@qq.com");

    // 配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("swagger学习")
                .select()
                /**
                 * RequestHandlerSelectors配置要扫描接口的方式
                 *      basePackage: 指定要扫描的包
                 *      any: 扫描全部
                 *      none: 都不扫描
                 *      withClassAnnotation: 扫描类上的注解
                 *      withMethodAnnotation: 扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("com.study"))
                // paths: 将哪些路径过滤掉
               // .paths("")
                .build();
    }

    // 配置apiInfo信息
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "swagger初步搭建", // 对应"Api Documentation",SwaggerAPI 名称
                "学习swagger的使用", // 对应"Api Documentation",API描述
                "V1.0", // 对应"Api Documentation右上角的版本",
                "urn:tos", // 对应"http://localhost:8080/v2/api-docs"
                DEFAULT_CONTACT, "Apache 2.0", // 对应"Apache 2.0",API版本号
                "http://www.apache.org/licenses/LICENSE-2.0", // 这个不用动
                new ArrayList());
    }

    // 设置多个分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("D");
    }
}

