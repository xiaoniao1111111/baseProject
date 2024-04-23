package com.study.behaviour_pattern.state;

/**
 * @类名称:StoppingState
 * @类描述:电梯停止状态类
 * @包名:behaviour_pattern.state
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class StoppingState extends LiftState {
    @Override
    public void open() {
        super.context.setLiftState(Context.OPENING_STATE);
        super.context.open();
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.close();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUNNING_STATE);
        super.context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了....");
    }
}
