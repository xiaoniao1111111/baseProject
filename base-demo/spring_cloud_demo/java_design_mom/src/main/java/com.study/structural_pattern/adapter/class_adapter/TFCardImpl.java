package com.study.structural_pattern.adapter.class_adapter;

/**
 * 适配者类
 *
 * @Author: WangXinWei
 * @Date: 2024-01-27-19:52
 * @Version 1.0
 */
public class TFCardImpl implements TFCard {

    @Override
    public String readTF() {
        String msg = "TFCard read msg : hello word TFCard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg :" + msg);
    }
}
