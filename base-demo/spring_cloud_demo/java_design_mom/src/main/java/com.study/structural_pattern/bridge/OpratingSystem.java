package com.study.structural_pattern.bridge;

/**
 * 抽象的操作系统类(抽象化角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-01-30-22:27
 * @Version 1.0
 */
public abstract class OpratingSystem {
    /**
     * 声明videoFile变量
     */
    protected VideoFile videoFile;

    public OpratingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    /**
     * 定义一个抽象的方法,因为我们不知道这个操作系统是windows还是linux,具体的系统由实现类完成
     *
     * @param fileName 文件名
     */
    public abstract void play(String fileName);
}
