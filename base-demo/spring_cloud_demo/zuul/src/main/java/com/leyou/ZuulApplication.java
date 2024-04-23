package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author WangXinWei
 * @Date 2022/3/20 16:26
 * @Version 1.0
 */
@SpringBootApplication
@EnableZuulProxy //开启zuul网关
@EnableDiscoveryClient // 可以被Rureka发现
@EnableHystrix
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
