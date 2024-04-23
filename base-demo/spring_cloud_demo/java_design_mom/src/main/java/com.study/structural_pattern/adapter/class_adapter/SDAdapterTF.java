package com.study.structural_pattern.adapter.class_adapter;

/**
 * 适配器类
 *
 * @Author: WangXinWei
 * @Date: 2024-01-27-20:04
 * @Version 1.0
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {
    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        writeTF(msg);
    }
}
