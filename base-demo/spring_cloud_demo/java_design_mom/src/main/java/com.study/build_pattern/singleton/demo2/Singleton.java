package com.study.build_pattern.singleton.demo2;

/**
 * 饿汉式: 静态代码块方式
 *
 * @Author: WangXinWei
 * @Date: 2023/04/25/18:34
 * @Description:
 */
public class Singleton {
    // 1.私有构造方法
    private Singleton() {}

    // 2.声明Singleton类型的变量
    private static Singleton instance;

    // 3.通过静态代码块的方式创建对象
    static {
        instance = new Singleton();
    }

    // 4.提供一个公共方法,让外界访问该对象
    public static Singleton getInstance(){
        return instance;
    }
}
