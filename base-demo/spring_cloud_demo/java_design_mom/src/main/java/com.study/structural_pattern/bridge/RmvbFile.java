package com.study.structural_pattern.bridge;

/**
 * rmvb视频文件(具体的实现化角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-01-30-22:25
 * @Version 1.0
 */
public class RmvbFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb视频文件 : " + fileName);
    }
}
