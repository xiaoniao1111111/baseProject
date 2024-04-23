package com.study.behaviour_pattern.observer;

/**
 * @类名称:WeixinUser
 * @类描述:具体的观察者角色类
 * @包名:behaviour_pattern.observer
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class WeixinUser implements Observer {

    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
