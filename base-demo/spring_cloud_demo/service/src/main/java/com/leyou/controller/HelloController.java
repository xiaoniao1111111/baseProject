package com.leyou.controller;

import com.leyou.pojo.TbUser;
import com.leyou.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author WangXinWei
 * @Date 2022/3/15 14:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("/say")
    public List<TbUser> say() {
        TbUser tbUser = new TbUser();
        tbUser.setId(1L);
        tbUser.setUserName("张三");
        TbUser tbUser1 = new TbUser();
        tbUser1.setId(2L);
        tbUser1.setUserName("李四");
        TbUser tbUser2 = new TbUser();
        tbUser2.setId(3L);
        tbUser2.setUserName("王五");
        return Arrays.asList(tbUser, tbUser1, tbUser2);
    }

    @GetMapping("/getUser/{id}")
    public TbUser getUser(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
