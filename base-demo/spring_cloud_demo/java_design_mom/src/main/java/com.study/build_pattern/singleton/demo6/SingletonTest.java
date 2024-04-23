package com.study.build_pattern.singleton.demo6;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/0:23
 * @Description:
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance==instance1);
    }
}
