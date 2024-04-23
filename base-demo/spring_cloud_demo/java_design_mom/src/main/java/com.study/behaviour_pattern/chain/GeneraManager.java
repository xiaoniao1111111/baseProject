package com.study.behaviour_pattern.chain;

/**
 * @Author: WangXinWei
 * @Date: 2024-03-04-21:32
 * @Version 1.0
 */
public class GeneraManager extends Handler {

    public GeneraManager() {
        super(NUM_THREE, NUM_SEVEN);
    }

    @Override
    protected void handleLeve(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天" + leave.getContent() + ".");
        System.out.println("总经理同意审批");
    }
}
