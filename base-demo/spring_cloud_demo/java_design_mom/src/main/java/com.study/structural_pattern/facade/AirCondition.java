package com.study.structural_pattern.facade;

/**
 * 空调类
 *
 * @Author: WangXinWei
 * @Date: 2024-01-30-23:14
 * @Version 1.0
 */
public class AirCondition {
    /**
     * 打开空调
     */
    public void on() {
        System.out.println("打开空调...");
    }

    /**
     * 关闭空调
     */
    public void off() {
        System.out.println("关闭空调...");
    }
}
