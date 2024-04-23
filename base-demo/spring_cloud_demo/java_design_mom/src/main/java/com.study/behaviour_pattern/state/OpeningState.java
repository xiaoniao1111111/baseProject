package com.study.behaviour_pattern.state;

/**
 * @类名称:OpeningState
 * @类描述:电梯开启状态类
 * @包名:behaviour_pattern.state
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class OpeningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯开启...");
    }

    @Override
    public void close() {
        // 修改状态
        super.context.setLiftState(Context.CLOSEING_STATE);
        // 调用当前状态中的context中的close方法
        super.context.close();
    }

    @Override
    public void run() {
        // 什么都不做
    }

    @Override
    public void stop() {
        // 什么都不做
    }
}