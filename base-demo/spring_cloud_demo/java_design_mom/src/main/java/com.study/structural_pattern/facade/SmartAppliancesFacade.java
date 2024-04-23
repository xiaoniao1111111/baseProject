package com.study.structural_pattern.facade;

/**
 * 智能音箱类(外观类,主要和该类对象进行交互)
 *
 * @Author: WangXinWei
 * @Date: 2024-01-30-23:17
 * @Version 1.0
 */
public class SmartAppliancesFacade {
    private Light light;
    private TV tv;
    private AirCondition airCondition;

    /**
     * 聚合电灯对象,电视机对象,空调对象
     */
    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    /**
     * 通过语音控制
     *
     * @param message
     */
    public void say(String message) {
        if (message.contains("打开")) {
            on();
        } else if (message.contains("关闭")) {
            off();
        } else {
            System.out.println("我还听不懂你说的");
        }
    }

    /**
     * 一键关闭功能
     */
    private void off() {
        light.off();
        tv.off();
        airCondition.off();
    }

    /**
     * 一键打开功能
     */
    private void on() {
        light.on();
        tv.on();
        airCondition.on();
    }

}
