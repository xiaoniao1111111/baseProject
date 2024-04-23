package com.study.structural_pattern.bridge;

/**
 * avi视频文件(具体的实现化角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-01-30-22:23
 * @Version 1.0
 */
public class AviFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件 : " + fileName);
    }
}
