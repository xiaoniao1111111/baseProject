package com.study.build_pattern.singleton.demo6;

/**
 * 懒汉式: 静态内部类
 *
 * @Author: WangXinWei
 * @Date: 2023/04/25/23:58
 * @Description:
 */
public class Singleton {
    // 1.私有构造方法
    private Singleton() {
    }

    // 2.生成一个Singleton内部类
    public static class SingletonHolder {
        // 3.初始化Singleton对象
        private static final Singleton INSTANCE = new Singleton();
    }

    // 4.提供一个公共静态方法,获取Singleton对象
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
