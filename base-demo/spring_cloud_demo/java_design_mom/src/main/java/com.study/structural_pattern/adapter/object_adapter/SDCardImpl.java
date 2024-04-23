package com.study.structural_pattern.adapter.object_adapter;

/**
 * 具体的SD卡类
 *
 * @Author: WangXinWei
 * @Date: 2024-01-27-19:57
 * @Version 1.0
 */
public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        String msg = "SDCard read msg : hello word SD";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg : " + msg);
    }
}
