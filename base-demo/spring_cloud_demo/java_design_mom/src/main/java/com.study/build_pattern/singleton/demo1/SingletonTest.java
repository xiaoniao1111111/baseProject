package com.study.build_pattern.singleton.demo1;


/**
 * @Author: WangXinWei
 * @Date: 2023/04/25/18:24
 * @Description:
 */
public class SingletonTest {
    public static void main(String[] args) {
        // 创建Sigleton对象
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        // 判断两次创建的对象是否同一个对象
        boolean b = instance == instance1;
        System.out.println("两次创建的对象是否一样: " + b);
    }
}
