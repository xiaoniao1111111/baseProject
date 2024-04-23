package com.study.build_pattern.prototype;

import java.util.logging.Logger;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-17-14:31
 * @Version 1.0
 */
public class RealizetypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 1.创建原对象
        Realizetype realizetype = new Realizetype();
        // 2.获取克隆对象
        Realizetype clone = realizetype.clone();
        System.out.println("原对象与克隆对象是否一样?"+(realizetype==clone));
    }
}
