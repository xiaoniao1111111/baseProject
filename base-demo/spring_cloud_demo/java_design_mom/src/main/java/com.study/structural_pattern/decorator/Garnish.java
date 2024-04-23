package com.study.structural_pattern.decorator;

import lombok.Data;

/**
 * 抽象装饰者角色
 *
 * @Author: WangXinWei
 * @Date: 2024-01-28-11:31
 * @Version 1.0
 */
@Data
public abstract class Garnish extends FastFood {
    /**
     * 声明快餐类的变量
     */
    private FastFood fastFood;

    public Garnish(FastFood fastFood,float price,String desc){
        super(price,desc);
        this.fastFood = fastFood;
    }
}
