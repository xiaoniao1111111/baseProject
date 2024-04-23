package com.study.structural_pattern.facade;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-30-23:22
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建智能音箱对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        // 控制家电
        facade.say("打开家电");
        System.out.println("=======================");
        facade.say("关闭家电");
    }
}
