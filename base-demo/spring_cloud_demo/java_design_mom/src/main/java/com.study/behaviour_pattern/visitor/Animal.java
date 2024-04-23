package com.study.behaviour_pattern.visitor;

/**
 * @类名称:Animal
 * @类描述:抽象元素角色类
 * @包名:behaviour_pattern.visitor
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public interface Animal {
    // 接受访问者访问的功能
    void accept(Person person);
}
