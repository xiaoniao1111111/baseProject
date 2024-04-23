package com.study.behaviour_pattern.state;

/**
 * @类名称:RunningState
 * @类描述:电梯运行状态类
 * @包名:behaviour_pattern.state
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class RunningState extends LiftState{
    @Override
    public void open() {
        // 什么都不做
    }

    @Override
    public void close() {
      // 什么都不做
    }

    @Override
    public void run() {
        System.out.println("电梯正在运行中...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.stop();
    }
}
