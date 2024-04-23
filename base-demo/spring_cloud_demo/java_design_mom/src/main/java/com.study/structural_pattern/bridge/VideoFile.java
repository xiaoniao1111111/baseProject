package com.study.structural_pattern.bridge;

/**
 * 视频文件(实现化角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-01-30-22:21
 * @Version 1.0
 */
public interface VideoFile {
    /**
     * 解码功能
     * @param fileName 文件名称
     */
    void decode(String fileName);
}
