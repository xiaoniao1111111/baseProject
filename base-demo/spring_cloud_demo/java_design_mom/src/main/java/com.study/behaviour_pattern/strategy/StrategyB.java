package com.study.behaviour_pattern.strategy;

/**
 * 具体策略类(封装算法)-中秋节活动
 *
 * @Author: WangXinWei
 * @Date: 2024-03-04-20:28
 * @Version 1.0
 */
public class StrategyB implements Strategy {
    @Override
    public void show() {
        System.out.println("满1000,减200");
    }
}
