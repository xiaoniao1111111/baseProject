package com.study.build_pattern.singleton.demo1;

/**
 * 饿汉式: 静态成员变量方式
 *
 * @Author: WangXinWei
 * @Date: 2023/04/25/18:12
 * @Description:
 */
public class Singleton {
    // 1.创建一个私有的构造方法,表示外界访问不到该类
    private Singleton() {}

    // 2.外界访问不到该类,则无法创建该对象,此时自己来创建对象
    private static Singleton instance = new Singleton();

    // 3.提供一个公共的访问方式,让外界获取该对象(不能创建对象,则不能调用非静态的方法,所以这里用静态方法)
    public static Singleton getInstance(){
        return instance;
    }

}
