package com.study.behaviour_pattern.template;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-01-17:35
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 炒包菜
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();
    }
}
