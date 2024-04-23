package com.study.behaviour_pattern.mediator;

/**
 * @类名称:HouseOwner
 * @类描述:具体的同事角色类
 * @包名:behaviour_pattern.mediator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class HouseOwner extends Person{
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 和中介者沟通的方法
    public void constact(String message){
        mediator.constact(message,this);
    }

    // 获取信息的方法
    public void getMessage(String message) {
        System.out.println("房主: " + name + "获取到的信息是: " + message);
    }
}
