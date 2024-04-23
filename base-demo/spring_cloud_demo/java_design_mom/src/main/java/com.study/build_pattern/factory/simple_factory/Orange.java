package com.study.build_pattern.factory.simple_factory;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/1:46
 * @Description:
 */
public class Orange extends Fuit{
    @Override
    public String getName() {
        return "橘子";
    }

    @Override
    public String getPrice() {
        return "1";
    }
}
