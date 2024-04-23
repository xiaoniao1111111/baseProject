package com.study.behaviour_pattern.chain;

/**
 * @Author: WangXinWei
 * @Date: 2024-03-04-21:36
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个请假条对象
        LeaveRequest leave = new LeaveRequest("小明", 10, "身体不适");

        // 创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneraManager generaManager = new GeneraManager();

        // 设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generaManager);

        // 小明提交请假申请d
        groupLeader.sumbit(leave);
    }
}
