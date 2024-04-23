package com.study.structural_pattern.bridge;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-30-22:35
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建mac系统对象
        OpratingSystem mac = new Mac(new AviFile());
        // 使用操作系统播放视频文件
        mac.play("战狼3");
    }
}
