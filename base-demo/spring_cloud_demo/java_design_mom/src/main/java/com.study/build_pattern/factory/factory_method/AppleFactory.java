package com.study.build_pattern.factory.factory_method;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/2:17
 * @Description:
 */
public class AppleFactory implements FuitFactory{
    @Override
    public Fuit getFuit() {
        return new Apple();
    }
}