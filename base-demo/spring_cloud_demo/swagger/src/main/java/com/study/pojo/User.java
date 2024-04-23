package com.study.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @类名称:User
 * @类描述:
 * @包名:com.study.pojo
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-18
 * @版本:V1.0.0
 */
@ApiModel("用户信息")
public class User {
    @ApiModelProperty("姓名")
    @NotBlank()
    private String name;
    @ApiModelProperty(value = "年龄",hidden = true)
    private String age;
}
