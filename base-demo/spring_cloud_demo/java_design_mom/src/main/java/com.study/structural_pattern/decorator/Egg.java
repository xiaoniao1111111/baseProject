package com.study.structural_pattern.decorator;

/**
 * 鸡蛋类(具体的装饰者角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-01-28-11:34
 * @Version 1.0
 */
public class Egg extends Garnish {

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    @Override
    public float cast() {
        // 计算价格
        return super.getPrice() + getFastFood().cast();
    }

    @Override
    public String getDesc() {
        // 鸡蛋+炒饭的名称
        return super.getDesc() + getFastFood().getDesc();
    }
}
