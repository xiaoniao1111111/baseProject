package com.study.build_pattern.singleton.demo5;

/**
 * 懒汉式: 双重检查方式
 *
 * @Author: WangXinWei
 * @Date: 2023/04/25/23:22
 * @Description:
 */
public class Singleton {
    // 1.构造私有方法
    private Singleton() {}

    // 2.声明成员变量
    private static Singleton instance;

    // 3.提供公共静态方法
    public static Singleton getInstance() {
        if (instance == null) {
            // 4.加上同步方法锁
            synchronized (Singleton.class) {
                instance = new Singleton();
                return instance;
            }
        } else {
            return instance;
        }
    }
}
