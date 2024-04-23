package com.study.structural_pattern.bridge;

/**
 * Mac操作系统(具体抽象化角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-01-30-22:33
 * @Version 1.0
 */
public class Mac extends OpratingSystem {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
