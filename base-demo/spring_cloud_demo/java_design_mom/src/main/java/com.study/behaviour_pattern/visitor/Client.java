package com.study.behaviour_pattern.visitor;

/**
 * @类名称:Client
 * @类描述:
 * @包名:behaviour_pattern.visitor
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建家对象
        Home home = new Home();

        // 添加元素
        home.add(new Dog());
        home.add(new Cat());

        // 创建自己
        Owner owner = new Owner();

        // 喂食
        home.action(owner);
    }
}
