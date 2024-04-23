package com.study.structural_pattern.flyweight;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-01-16:43
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 获取I图形对象
        AbstractBox box1 = BoxFactory.getInstance().getShape("I");
        box1.display("灰色");

        AbstractBox box2 = BoxFactory.getInstance().getShape("L");
        box2.display("绿色");

        AbstractBox box3 = BoxFactory.getInstance().getShape("O");
        box3.display("蓝色");

        AbstractBox box4 = BoxFactory.getInstance().getShape("O");
        box4.display("红色");
        System.out.println("两个图形是否是同一个对象: "+(box3==box4));

    }
}
