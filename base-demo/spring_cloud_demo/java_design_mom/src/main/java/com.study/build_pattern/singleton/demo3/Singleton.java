package com.study.build_pattern.singleton.demo3;

/**
 * 懒汉式: 线程不安全
 * @Author: WangXinWei
 * @Date: 2023/04/25/19:55
 * @Description:
 */
public class Singleton {
    // 1.私有构造方法
    private Singleton(){}
    // 2.声明Singleton类型的变量
    private static Singleton instance;
    // 3.提供公共方法供外部调用
    public static Singleton getInstance(){
        // 4.判断是否已创建当前对象,若创建则直接返回,没有创建则创建
        if (instance==null){
            instance = new Singleton();
            return instance;
        }else {
            return instance;
        }
    }
}
