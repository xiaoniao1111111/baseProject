package com.study.behaviour_pattern.visitor;

/**
 * @类名称:Owner
 * @类描述:具体访问者角色类(自己)
 * @包名:behaviour_pattern.visitor
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Owner implements Person {
    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂食狗");
    }
}
