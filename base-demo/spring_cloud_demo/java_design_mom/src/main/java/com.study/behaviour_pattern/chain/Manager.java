package com.study.behaviour_pattern.chain;

/**
 * @Author: WangXinWei
 * @Date: 2024-03-04-21:32
 * @Version 1.0
 */
public class Manager extends Handler {

    public Manager() {
        super(0, NUM_ONE);
    }

    @Override
    protected void handleLeve(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天" + leave.getContent() + ".");
        System.out.println("部门经理同意审批");
    }
}
