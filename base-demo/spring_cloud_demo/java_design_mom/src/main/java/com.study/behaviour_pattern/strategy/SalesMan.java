package com.study.behaviour_pattern.strategy;

/**
 * 促销员(环境类)
 *
 * @Author: WangXinWei
 * @Date: 2024-03-04-20:30
 * @Version 1.0
 */
public class SalesMan {
    /**
     * 聚合策略类对象
     */
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 由促销员展示促销活动给客户
     */
    public void salesManShow() {
        strategy.show();

    }
}
