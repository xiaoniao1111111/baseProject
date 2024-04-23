package com.study.behaviour_pattern.chain;

/**
 * 抽象类
 *
 * @Author: WangXinWei
 * @Date: 2024-03-04-21:23
 * @Version 1.0
 */
public abstract class Handler {
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    /**
     * 该领导处理请假的区间
     */
    private int numStart;
    private int numEnd;

    /**
     * 声明后继者(上级领导)
     */
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    /**
     * 设置上级领导对象
     */
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 各级领导处理请假的方法
     *
     * @param leave
     */
    protected abstract void handleLeve(LeaveRequest leave);

    /**
     * 提交请假条
     *
     * @param leave
     */
    public final void sumbit(LeaveRequest leave) {
        // 当前领导进行审批
        this.handleLeve(leave);
        // 如果有上级领导,且允许请假天数大于请求天数时,直接通过,反之则传递给上级
        if (this.nextHandler != null && leave.getNum() > this.numEnd) {
            this.nextHandler.sumbit(leave);
        } else {
            System.out.println("流程结束! ");
        }
    }
}
