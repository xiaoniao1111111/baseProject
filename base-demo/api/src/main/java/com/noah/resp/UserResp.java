package com.noah.resp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 10:18
 * @Version 1.0
 */
@ExcelTarget("UserResp")
@Data
public class UserResp implements java.io.Serializable{
    /**
     * 用户名
     */
    @Excel(name="用户名",isImportField = "true_st")
    private String userName;

    /**
     * 密码
     */
    @Excel(name="密码",isImportField = "true_st")
    private String password;

    /**
     * 姓名
     */
    @Excel(name="姓名",isImportField="true_st")
    private String name;

    /**
     * 年龄
     */
    @Excel(name="年龄",isImportField = "true_st")
    private Integer age;

    /**
     * 性别，1男性，2女性
     */
    @Excel(name = "性别",replace = {"男_true","女_false"})
    private Boolean sex;

    /**
     * 出生日期
     */
    @Excel(name="出生日期",databaseFormat = "yyyyMMddHHmmss",format = "yyyy-MM-dd",
            isImportField = "true_st")
    private Date birthday;

    /**
     * 创建时间
     */
    @Excel(name="创建时间",databaseFormat = "yyyyMMddHHmmss",format = "yyyy-MM-dd",
            isImportField = "true_st")
    private Date created;

    /**
     * 更新时间
     */
    @Excel(name="更新时间",databaseFormat = "yyyyMMddHHmmss",format = "yyyy-MM-dd",
            isImportField = "true_st")
    private Date updated;

    public UserResp() {
    }

    @Override
    public String toString() {
        return "UserResp{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResp userResp = (UserResp) o;
        return Objects.equals(userName, userResp.userName) &&
                Objects.equals(password, userResp.password) &&
                Objects.equals(name, userResp.name) &&
                Objects.equals(age, userResp.age) &&
                Objects.equals(sex, userResp.sex) &&
                Objects.equals(birthday, userResp.birthday) &&
                Objects.equals(created, userResp.created) &&
                Objects.equals(updated, userResp.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, name, age, sex, birthday, created, updated);
    }

    public UserResp(String userName, String password, String name, Integer age, Boolean sex, Date birthday, Date created, Date updated) {
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
