package com.study.build_pattern.singleton.demo4;

/**
 * 懒汉式: 线程安全的
 * @Author: WangXinWei
 * @Date: 2023/04/25/20:07
 * @Description:
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
            return instance;
        } else {
            return instance;
        }
    }
}
