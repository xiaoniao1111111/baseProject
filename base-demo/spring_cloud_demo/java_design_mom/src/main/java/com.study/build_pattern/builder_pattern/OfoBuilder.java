package com.study.build_pattern.builder_pattern;

/**
 *  ofo单车构建者
 * @Author: WangXinWei
 * @Date: 2024-01-17-15:58
 * @Version 1.0
 */
public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}
