package com.study.behaviour_pattern.state;

/**
 * @类名称:Context
 * @类描述:环境角色类
 * @包名:behaviour_pattern.state
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public  class Context {
    public static final OpeningState OPENING_STATE = new OpeningState();
    public static final CloseingState CLOSEING_STATE = new CloseingState();
    public static final RunningState RUNNING_STATE = new RunningState();
    public static final StoppingState STOPPING_STATE = new StoppingState();

    // 定义一个当前电梯状态变量
    private LiftState liftState;

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        // 设置当前状态对象中的context对象
        this.liftState.setContext(this);
    }

    public void open(){
        this.liftState.open();
    }

    public void close(){
        this.liftState.close();
    }

    public void run(){
        this.liftState.run();
    }

    public void stop(){
        this.liftState.stop();
    }
}
