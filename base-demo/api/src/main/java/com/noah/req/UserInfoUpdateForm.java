package com.noah.req;

import javax.validation.constraints.NotBlank;

/**
 * 用户信息更新表单
 *
 * @Author: WangXinWei
 * @Date: 2020/1/14 9:33
 * @Version 1.0
 */
public class UserInfoUpdateForm {
    @NotBlank(message = "用户名不能为空")
    private String userName;

    public UserInfoUpdateForm(String userName) {
        this.userName = userName;
    }

    public UserInfoUpdateForm() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
