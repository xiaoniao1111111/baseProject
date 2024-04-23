package com.noah.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: WangXinWei
 * @Date: 2020/1/14 10:17
 * @Version 1.0
 */
public class UserInfoAddForm {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    private Integer age;

    /**
     * 性别，0男性，1女性
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private String birthday;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
