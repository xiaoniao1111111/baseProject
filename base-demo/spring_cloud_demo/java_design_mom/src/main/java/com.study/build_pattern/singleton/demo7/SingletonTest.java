package com.study.build_pattern.singleton.demo7;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/0:57
 * @Description:
 */
public class SingletonTest {
    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        System.out.println(instance==instance1);
    }
}
