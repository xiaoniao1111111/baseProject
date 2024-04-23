package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author WangXinWei
 * @Date 2022/3/18 10:54
 * @Version 1.0
 */
@SpringBootApplication  // 表示这是一个应用启动类
@EnableDiscoveryClient // 表示作为eureka的客户端,可以被Eureka发现
@EnableHystrix  // 开启熔断
@EnableFeignClients // 开启远程调用 Feign
public class UserClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class);
    }

    @Bean
    @LoadBalanced // 开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
