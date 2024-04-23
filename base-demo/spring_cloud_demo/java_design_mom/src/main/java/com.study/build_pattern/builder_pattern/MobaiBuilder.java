package com.study.build_pattern.builder_pattern;

/**
 * 用来构建摩拜单车对象
 *
 * @Author: WangXinWei
 * @Date: 2024-01-17-15:56
 * @Version 1.0
 */
public class MobaiBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}
