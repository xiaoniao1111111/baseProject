package com.study.behaviour_pattern.mediator;

/**
 * @类名称:Pserson
 * @类描述:抽象同事类
 * @包名:behaviour_pattern.mediator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
