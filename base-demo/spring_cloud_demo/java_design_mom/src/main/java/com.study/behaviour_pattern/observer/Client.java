package com.study.behaviour_pattern.observer;

/**
 * @类名称:Client
 * @类描述:
 * @包名:behaviour_pattern.observer
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Client {
    public static void main(String[] args) {
        // 1.创建公众号对象
        SubjectImpl subject = new SubjectImpl();

        // 2.订阅公众号
        subject.attach(new WeixinUser("张三"));
        subject.attach(new WeixinUser("李四"));
        subject.attach(new WeixinUser("王五"));

        // 3.公众号更新,发出消息给订阅者(观察者对象)
        subject.notify("专栏更新了");
    }
}
