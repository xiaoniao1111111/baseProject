package com.study.structural_pattern.decorator;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-28-11:39
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 点一份炒饭
        FastFood friedRice = new FriedRice();
        System.out.println(friedRice.getDesc()+"---"+friedRice.getPrice()+"元");

        System.out.println("========================================");

        // 在上面的炒饭中加一个鸡蛋
        friedRice = new Egg(friedRice);
        System.out.println(friedRice.getDesc()+"---"+ friedRice.cast()+"元");
        System.out.println("========================================");
        friedRice = new Egg(friedRice);
        System.out.println(friedRice.getDesc()+"---"+ friedRice.cast()+"元");

    }
}
