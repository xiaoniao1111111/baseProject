package com.study.behaviour_pattern.template;

/**
 * 炒菜心类
 *
 * @Author: WangXinWei
 * @Date: 2024-02-01-17:33
 * @Version 1.0
 */
public class ConcreteClass_CaiXin extends AbstractClass {
    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是蒜蓉");
    }
}
