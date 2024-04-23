package com.study.behaviour_pattern.chain;

/**
 * 请假条类
 *
 * @Author: WangXinWei
 * @Date: 2024-03-04-21:21
 * @Version 1.0
 */
public class LeaveRequest {
    /**
     * 请假人
     */
    private String name;

    /**
     * 请假天数
     */
    private int num;

    /**
     * 请假内容
     */
    private String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}
