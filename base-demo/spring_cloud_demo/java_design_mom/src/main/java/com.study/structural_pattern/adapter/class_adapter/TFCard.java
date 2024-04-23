package com.study.structural_pattern.adapter.class_adapter;

/**
 * 适配者类的接口
 *
 * @Author: WangXinWei
 * @Date: 2024-01-19-10:54
 * @Version 1.0
 */
public interface TFCard {
    /**
     * 从TF卡中读取数据
     *
     * @return
     */
    String readTF();

    /**
     * 往TF卡中写数据
     */
    void writeTF(String msg);
}
