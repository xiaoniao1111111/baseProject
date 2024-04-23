package com.study.behaviour_pattern.observer;

/**
 * @类名称:Subject
 * @类描述:抽象主题类
 * @包名:behaviour_pattern.observer
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public interface Subject {
    // 添加观察者对象
    void attach(Observer observer);

    // 删除观察者对象
    void delete(Observer observer);

    // 通知观察者更新消息
    void notify(String message);
}
