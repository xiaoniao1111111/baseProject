package com.study.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @类名称:Student
 * @类描述:
 * @包名:com.study.pojo
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-20
 * @版本:V1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JSONType(includes = {"name","birthday"},orders = {"birthday","name"})
public class Student {
    private Integer id;
    @JSONField(name = "studentName",ordinal = 1)
    private String name;
    @JSONField(ordinal = 2)
    private Integer age;
    @JSONField(deserialize = false)
    private String email;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
}
