package com.study.structural_pattern.facade;

/**
 * 电灯类
 *
 * @Author: WangXinWei
 * @Date: 2024-01-30-23:09
 * @Version 1.0
 */
public class Light {
    /**
     * 开灯的功能
     */
    public void on() {
        System.out.println("打开电灯...");
    }

    /**
     * 关灯的功能
     */
    public void off() {
        System.out.println("关闭电灯...");
    }
}
