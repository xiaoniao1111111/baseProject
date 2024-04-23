package com.study.structural_pattern.adapter.class_adapter;

/**
 * 计算机类
 * @Author: WangXinWei
 * @Date: 2024-01-27-19:59
 * @Version 1.0
 */
public class Computer {
    /**
     * 从SD卡中读取数据
     */
    public String readSD(SDCard sdCard){
        if (sdCard==null){
            throw new NullPointerException("sd card is not null");
        }
        return sdCard.readSD();
    }
}
