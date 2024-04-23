package com.study.structural_pattern.proxy;

/**
 * 代理对象
 *
 * @Author: WangXinWei
 * @Date: 2024-01-19-10:29
 * @Version 1.0
 */
public class ProxyObject implements AbstractInterFace {
    private TargetObject targetObject = new TargetObject();

    @Override
    public void say() {
        System.out.println("说什么");
        targetObject.say();
    }
}
