package com.study.structural_pattern.proxy;

/**
 * 目标对象
 * @Author: WangXinWei
 * @Date: 2024-01-19-10:30
 * @Version 1.0
 */
public class TargetObject implements AbstractInterFace{
    @Override
    public void say() {
        System.out.println("您好");
    }
}
