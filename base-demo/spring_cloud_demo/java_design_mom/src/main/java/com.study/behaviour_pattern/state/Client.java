package com.study.behaviour_pattern.state;

/**
 * @类名称:Client
 * @类描述:
 * @包名:behaviour_pattern.state
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建环境角色对象
        Context context = new Context();
        // 设置当前电梯状态
        context.setLiftState(new StoppingState());

        context.open();
        context.run();
        context.close();

        context.stop();
    }
}
