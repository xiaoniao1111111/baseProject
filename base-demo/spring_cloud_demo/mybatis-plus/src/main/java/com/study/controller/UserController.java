package com.study.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.domain.TbUser;
import com.study.servier.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @类名称:UserController
 * @类描述:
 * @包名:com.study.controller
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-19
 * @版本:V1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById")
    public TbUser getUserById() {
        return this.userService.getUserById();
    }

    @GetMapping("/getUserByIds")
    public List<TbUser> getUserByIds() {
        return this.userService.getUserByIds();
    }


    @GetMapping("/insert")
    public void insert() {
        this.userService.insert();
    }

    @GetMapping("/updateById")
    public void updateById() {
        this.userService.updateById();
    }

    @GetMapping("/updateByWrapper")
    public void updateByWrapper() {
        this.userService.updateByWrapper();
    }

    @GetMapping("/updateByWrapper2")
    public void updateByWrapper2() {
        this.userService.updateByWrapper2();
    }


    @GetMapping("/deleteById")
    public void deleteById() {
        this.userService.deleteById();
    }

    @GetMapping("/deleteByMap")
    public void deleteByMap() {
        this.userService.deleteByMap();
    }

    @GetMapping("/deleteByWrapper")
    public void deleteByWrapper() {
        this.userService.deleteByWrapper();
    }

    @GetMapping("/deleteByIds")
    public void deleteByIds() {
        this.userService.deleteByIds();
    }

    @GetMapping("/pageList")
    public IPage<TbUser> pageList() {
        return this.userService.pageList();
    }

    @GetMapping("/selectListByMybatis")
    public List<TbUser> selectListByMybatis() {
        return this.userService.selectListByMybatis();
    }

    @GetMapping("/selectListByAlleq")
    public List<TbUser> selectListByAlleq() {
        return this.userService.selectListByAlleq();
    }

    @GetMapping("/selectListByOr")
    public List<TbUser> selectListByOr() {
        return this.userService.selectListByOr();
    }

    @GetMapping("/selectListBySelect")
    public List<TbUser> selectListBySelect() {
        return this.userService.selectListBySelect();
    }

    @GetMapping("/updateByVersion")
    public void updateByVersion() {
        this.userService.updateByVersion();
    }


    @GetMapping("/page")
    public void page() {
        this.userService.page();
    }
}
