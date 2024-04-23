package com.leyou.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.leyou.pojo.User;

/**
 * @Author WangXinWei
 * @Date 2022/3/19 18:57
 * @Version 1.0
 */
// 参数1: 服务端应用名称  参数2: Hystrx回调类
@FeignClient(value = "user-server", fallback = HystrixImpl.class)
public interface FeignAPI {
    @GetMapping("/user/getUser/{id}")
    User getUser(@PathVariable("id") Long id);

    @DeleteMapping("/user/deleteUser/{id}")
    void deleteUser(@PathVariable("id") Long id);
}
