package com.study.build_pattern.factory.abstract_factory;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/3:02
 * @Description:
 */
public class FactoryTest {
    public static void main(String[] args) {
        DefultFactory defultFactory = new DefultFactory();
        Fuit fuit = defultFactory.getFuit();
        Car car = defultFactory.getCar();
        System.out.println(fuit.getName()+car.getName());
    }
}
