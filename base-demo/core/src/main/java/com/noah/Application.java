package com.noah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: WangXinWei
 * @Date: 2019/4/9 21:29
 * @Version 1.0
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan({
        "com.noah.**.config",
        "com.noah.**.controller",
        "com.noah.**.service",
        "com.noah.**.service.Impl",
        "com.noah.**.job",
        "com.noah.**.lock",
        "com.noah.**.interceptor",
        "com.noah.**.mapper"
})
@MapperScan("com.noah.**.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
