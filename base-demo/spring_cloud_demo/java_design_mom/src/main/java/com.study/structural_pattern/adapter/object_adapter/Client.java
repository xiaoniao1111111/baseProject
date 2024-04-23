package com.study.structural_pattern.adapter.object_adapter;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-27-20:02
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建计算机对象
        Computer computer = new Computer();
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("============================");
        // 使用该电脑读取TF卡中的数据
        // 创建适配器类对象
        String msg1 = computer.readSD(new SDAdapterTF(new TFCardImpl()));
        System.out.println(msg1);
    }
}
