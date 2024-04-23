package com.study.behaviour_pattern.visitor;

/**
 * @类名称:Dog
 * @类描述:具体元素角色(宠物猫)
 * @包名:behaviour_pattern.visitor
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Cat implements Animal {
    @Override
    public void accept(Person person) {
        // 给宠物狗喂食
        person.feed(this);
        System.out.println("好好吃,喵喵喵...");
    }
}
