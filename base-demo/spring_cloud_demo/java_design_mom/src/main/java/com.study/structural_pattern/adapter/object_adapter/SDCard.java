package com.study.structural_pattern.adapter.object_adapter;

/**
 * 目标接口
 *
 * @Author: WangXinWei
 * @Date: 2024-01-27-19:55
 * @Version 1.0
 */
public interface SDCard {
    /**
     * 从SD卡中读取数据
     */

    String readSD();

    /**
     * 往SD卡中写数据
     */
    void writeSD(String msg);
}
