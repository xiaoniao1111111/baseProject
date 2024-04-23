package com.study.behaviour_pattern.strategy;

/**
 * 具体策略类(封装算法)-春节活动
 *
 * @Author: WangXinWei
 * @Date: 2024-03-04-20:28
 * @Version 1.0
 */
public class StrategyA implements Strategy {
    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
