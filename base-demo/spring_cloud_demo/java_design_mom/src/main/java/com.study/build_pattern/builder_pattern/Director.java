package com.study.build_pattern.builder_pattern;

/**
 *  指挥者类,用来组合
 * @Author: WangXinWei
 * @Date: 2024-01-17-15:59
 * @Version 1.0
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }


}
