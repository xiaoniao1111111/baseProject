package com.study.build_pattern.builder_pattern;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-17-15:53
 * @Version 1.0
 */
public abstract class Builder {
    protected Bike bike = new Bike();

    /**
     * 构建车架
     */
    public abstract void buildFrame();

    /**
     * 构建车座
     */
    public abstract void buildSeat();

    /**
     * 创建自行车
     *
     * @return
     */
    public abstract Bike buildBike();

    /**
     * 这里的做法是将指挥者类省去了,构建的过程由这个方法完成
     *
     * @return
     */
    public Bike construct() {
        this.buildFrame();
        this.buildSeat();
        return this.buildBike();
    }
}
