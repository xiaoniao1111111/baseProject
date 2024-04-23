package com.study.structural_pattern.adapter.class_adapter;

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
        // 使用该计算机读取TF卡中的数据
        // 定义适配器类
        String msg1 = computer.readSD(new SDAdapterTF());
        System.out.println(msg1);
    }
}
