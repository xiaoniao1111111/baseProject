package com.study.build_pattern.factory.factory_method;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/2:19
 * @Description:
 */
public class FuitTest {
    public static void main(String[] args) {
        FuitFactory factory = new AppleFactory();
        Fuit fuit = factory.getFuit();
        System.out.println(fuit.getName()+"----"+fuit.getPrice());
    }
}
