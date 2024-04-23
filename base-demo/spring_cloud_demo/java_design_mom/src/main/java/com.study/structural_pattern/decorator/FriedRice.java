package com.study.structural_pattern.decorator;

/**
 * 炒饭(具体构件角色)
 * @Author: WangXinWei
 * @Date: 2024-01-28-11:24
 * @Version 1.0
 */
public class FriedRice extends FastFood {

    public FriedRice(){
        super(10,"炒饭");
    }

    @Override
    public float cast() {
        return getPrice();
    }
}
