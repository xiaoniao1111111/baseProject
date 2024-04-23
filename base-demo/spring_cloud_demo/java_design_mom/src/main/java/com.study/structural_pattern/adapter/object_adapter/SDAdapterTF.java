package com.study.structural_pattern.adapter.object_adapter;

/**
 * 适配器类
 *
 * @Author: WangXinWei
 * @Date: 2024-01-27-20:04
 * @Version 1.0
 */
public class SDAdapterTF implements SDCard {
    // 声明适配者类
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
