package com.study.structural_pattern.decorator;

/**
 * 炒面(具体的构件角色)
 * @Author: WangXinWei
 * @Date: 2024-01-28-11:29
 * @Version 1.0
 */
public class FriedNoodles extends FastFood{

    public FriedNoodles(){
        super(12,"炒面");
    }
    @Override
    public float cast() {
        return getPrice();
    }
}
