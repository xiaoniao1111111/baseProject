package com.study.behaviour_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名称:SubjectImpl
 * @类描述:
 * @包名:behaviour_pattern.observer
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class SubjectImpl implements Subject{

    // 定义一个集合来存储多个观察者对象
    private List<Observer> observerList = new ArrayList<>();


    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
