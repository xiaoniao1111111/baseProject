package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @类名称:User
 * @类描述:
 * @包名:com.study.pojo
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-04-22
 * @版本:V1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
}
