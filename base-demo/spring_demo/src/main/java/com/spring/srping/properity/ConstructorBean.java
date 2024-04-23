package com.spring.srping.properity;

import lombok.Data;

/**
 * @Author WangXinWei
 * @Date 2022/3/5 17:12
 * @Version 1.0
 */
@Data
public class ConstructorBean {
    private String name;
    private Integer age;
    private Boolean sex;

    public ConstructorBean(String name, Integer age, Boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public ConstructorBean() {
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
}
