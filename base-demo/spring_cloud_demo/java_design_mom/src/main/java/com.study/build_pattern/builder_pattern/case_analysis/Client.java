package com.study.build_pattern.builder_pattern.case_analysis;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-17-16:50
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Phone build = new Phone.Builder()
                .cpu("intel")
                .mainboard("华硕主板")
                .screen("三星屏幕")
                .memory("金士顿内存条")
                .build();
        System.out.println(build);
    }
}
