package com.study.build_pattern.factory.simple_factory;

/**
 * 水果
 * @Author: WangXinWei
 * @Date: 2023/04/26/1:41
 * @Description:
 */
public abstract class Fuit {
    private String name;
    private String price;

    public abstract String getName() ;

    public abstract String getPrice();
}
