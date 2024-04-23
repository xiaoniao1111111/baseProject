package com.study.behaviour_pattern.state;

/**
 * @类名称: LiftState
 * @类描述:
 * @包名: behaviour_pattern.state
 * @项目名称: base-demo
 * @作者: wxw
 * @日期: 2024-03-10
 * @版本: V1.0.0
 */
public abstract class LiftState {

    // 声明环境角色
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    // 电梯开启操作
    public abstract void open();

    // 电梯关闭操作
    public abstract void close();

    // 电梯运行操作
    public abstract void run();

    // 电梯停在操作
    public abstract void stop();
}
