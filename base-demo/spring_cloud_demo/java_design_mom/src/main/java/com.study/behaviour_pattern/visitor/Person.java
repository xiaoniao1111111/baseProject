package com.study.behaviour_pattern.visitor;

/**
 * @类名称:Person
 * @类描述:抽象访问者角色
 * @包名:behaviour_pattern.visitor
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public interface Person {
    // 喂食-猫
    void feed(Cat cat);

    // 喂食-狗
    void feed(Dog dog);
}
