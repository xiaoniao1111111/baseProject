package com.springcloud.controller;

import com.springcloud.pojo.User;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author WangXinWei
 * @Date 2022/3/18 10:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public List<User> getUsers(@RequestParam("ids") List<Long> ids) {
        return userService.getUsers(ids);
    }
}
