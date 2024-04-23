package com.study.structural_pattern.flyweight;

/**
 * 抽象享元角色
 *
 * @Author: WangXinWei
 * @Date: 2024-02-01-16:31
 * @Version 1.0
 */
public abstract class AbstractBox {
    /**
     * 获取图形方法
     *
     * @return
     */
    public abstract String getShape();

    /**
     * 显示图形及颜色
     *
     * @param color
     */
    public void display(String color) {
        System.out.println("方块形状: " + getShape() + ", 颜色: " + color);
    }
}
