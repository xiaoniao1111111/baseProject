package com.study.behaviour_pattern.strategy;

/**
 * @Author: WangXinWei
 * @Date: 2024-03-04-20:32
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 春节活动
        SalesMan salesMan = new SalesMan(new StrategyA());
        salesMan.salesManShow();
        System.out.println("================================");
        // 中秋活动
        salesMan.setStrategy(new StrategyB());
        salesMan.salesManShow();
        System.out.println("==================================");
        // 圣诞活动
        salesMan.setStrategy(new StrategyC());
        salesMan.salesManShow();
    }
}
