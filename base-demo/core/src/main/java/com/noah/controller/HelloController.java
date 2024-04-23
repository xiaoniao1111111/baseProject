package com.noah.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.noah.common.BaseResponse;
import com.noah.common.PaginationRequest;
import com.noah.domain.TbUser;
import com.noah.exception.ResponseCode;
import com.noah.req.PageReq;
import com.noah.req.UserInfoAddForm;
import com.noah.req.UserInfoUpdateForm;
import com.noah.service.ITbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @Author: WangXinWei
 * @Date: 2019/4/9 21:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "测试",tags = {"测试"})
public class HelloController {

    @Autowired
    private ITbUserService tbUserService;


    @RequestMapping(value = "/page/orderList", method = RequestMethod.POST)
    @ApiOperation(value = "获取订单列表",notes = "获取订单列表")
    public BaseResponse getTbUserPageByPage(@Validated @RequestBody PaginationRequest<PageReq> pageReq, BindingResult bindingResult) {

        log.info("传入的当前参数:{}", JSON.toJSONString(pageReq));
      /*  if (bindingResult.hasErrors()) {
            return BaseResponse.invalidParam(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }*/
     Page<TbUser> tbUserByID = tbUserService.getTbUserByID(pageReq);
        return BaseResponse.success(tbUserByID);
    }

    @PutMapping(value = "/insertLock/updateUserByID/{id}")
    @ApiOperation(value = "修改用户信息",notes = "修改用户信息")
    public BaseResponse updateUserByID(@ApiParam(name = "id",value = "用户ID")
                               @PathVariable("id")String id, @RequestBody@Valid UserInfoUpdateForm userInfoUpdateForm){
        tbUserService.updateUserByID(id,userInfoUpdateForm);
        return BaseResponse.success(ResponseCode.SUCCESS.getMsg());
    }

    @RequestMapping(value = "/userList/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    public BaseResponse getUserListByID(@ApiParam(name = "ID",value = "用户ID",required = true)
                                                    @PathVariable(value = "id",required = true) String id){
        log.info("传入的当前参数:{}", JSON.toJSONString(id));
        TbUser tbUser = tbUserService.getUserListByID(id);
        return BaseResponse.success(tbUser);
    }
    @PostMapping(value = "/addUserInfo/")
    @ApiOperation(value = "新增用户",notes = "新增用户")
    public BaseResponse addUserInfo(@RequestBody UserInfoAddForm userInfoAddForm){
        tbUserService.addUserInfo(userInfoAddForm);
        return BaseResponse.success(ResponseCode.SUCCESS.getMsg());
    }

    @DeleteMapping(value = "/deleteUserInfo/{id}")
    @ApiOperation(value = "删除用户",notes = "删除用户")
    public BaseResponse deleteUserInfo(@PathVariable(value = "id",required = true)String id){
        tbUserService.deleteUserInfo(id);
        return BaseResponse.success(ResponseCode.SUCCESS.getMsg());
    }

    @GetMapping(value = "/user")
    public static void getHello(@Validated PageReq req){
        System.out.println("hello word");
    }
}
