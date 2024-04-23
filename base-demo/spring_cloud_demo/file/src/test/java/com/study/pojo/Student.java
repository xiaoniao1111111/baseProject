package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @类名称:Student
 * @类描述:
 * @包名:com.study.pojo
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-24
 * @版本:V1.0.0
 */
@Data
@AllArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String age;
    private String sex;
    private Integer count;
}
