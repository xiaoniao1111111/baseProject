package com.study.build_pattern.factory.abstract_factory;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/3:01
 * @Description:
 */
public class DefultFactory implements HuaWeiFactory{
    @Override
    public Fuit getFuit() {
        return new Apple();
    }

    @Override
    public Car getCar() {
        return new SACar();
    }
}
