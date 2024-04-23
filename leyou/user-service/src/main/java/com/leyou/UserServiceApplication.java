package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/11/14:22
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.leyou.mapper")
@EnableDiscoveryClient // 表示作为eureka的客户端,可以被Eureka发现(这个注解同时支持负载均衡的发现)
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class);
    }
}
