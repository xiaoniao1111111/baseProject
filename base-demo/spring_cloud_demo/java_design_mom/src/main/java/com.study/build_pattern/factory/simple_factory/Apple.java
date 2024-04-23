package com.study.build_pattern.factory.simple_factory;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/1:41
 * @Description:
 */
public class Apple extends Fuit{

    @Override
    public String getName() {
        return "苹果";
    }

    @Override
    public String getPrice() {
        return "3";
    }
}
