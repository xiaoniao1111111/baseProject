package com.study.build_pattern.singleton.demo3;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/25/20:04
 * @Description:
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        boolean b = instance == instance1;
        System.out.println("两次创建的对象是否一样: " + b);
    }
}
