package com.noah.resp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 16:41
 * @Version 1.0
 */
@ExcelTarget("UserInsertResq")
@Data
public class UserInsertResq {
    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String userName;

    /**
     * 密码
     */
    @Excel(name = "密码")
    private String password;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 年龄
     */
    @Excel(name = "年龄")
    private Integer age;

    /**
     * 性别，1男性，2女性
     */
    @Excel(name = "性别", replace = {"true_男", "false_女"})
    private Boolean sex;

    /**
     * 出生日期
     */
    @Excel(name = "出生日期", databaseFormat = "yyyy-MM-dd", format = "yyyyMMdd")
    private Date birthday;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间", databaseFormat = "yyyy-MM-dd", format = "yyyyMMdd")
    private Date created;

    /**
     * 更新时间
     */
    @Excel(name = "更新时间", databaseFormat = "yyyy-MM-dd", format = "yyyyMMdd")
    private Date updated;

    public UserInsertResq() {
    }

    public UserInsertResq(String userName, String password, String name, Integer age, Boolean sex, Date birthday, Date created, Date updated) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.created = created;
        this.updated = updated;
    }

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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
