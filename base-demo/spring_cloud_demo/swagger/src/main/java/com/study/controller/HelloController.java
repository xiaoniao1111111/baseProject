package com.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类名称:HelloController
 * @类描述:
 * @包名:com.study.controller
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-18
 * @版本:V1.0.0
 */
@RestController("/user")
@Api(tags = "用户信息",description = "用来查询用户信息的")
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(("hello测试"))
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value = "用户名",readOnly = false),
            @ApiImplicitParam(name="password",value = "密码",readOnly = false)
    })
    public void swaggerTest(String name,String password){
        System.out.println("swagger成功.....");
    }
}
