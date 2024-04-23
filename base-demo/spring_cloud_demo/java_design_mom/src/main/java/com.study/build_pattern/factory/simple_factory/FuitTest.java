package com.study.build_pattern.factory.simple_factory;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/1:52
 * @Description:
 */
public class FuitTest {
    public static void main(String[] args) {
        FuitStore fuitStore = new FuitStore();
        Fuit fuit = fuitStore.getFuit("苹果");
        System.out.println(fuit.getName()+"----"+fuit.getPrice());
    }
}
