package com.leyou.controller;

import com.leyou.pojo.User;
import com.leyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author WangXinWei
 * @Date 2022/3/15 14:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("/say")
    public String say() {
        return "hello springBoot";
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
