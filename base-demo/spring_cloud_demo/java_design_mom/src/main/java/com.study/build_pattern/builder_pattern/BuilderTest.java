package com.study.build_pattern.builder_pattern;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-17-16:10
 * @Version 1.0
 */
public class BuilderTest {
    public static void main(String[] args) {
        MobaiBuilder mobaiBuilder = new MobaiBuilder();
        Bike bike = mobaiBuilder.construct();
        System.out.println(bike.getFrame()+"-------"+bike.getSeat());
    }
}
