package com.study.behaviour_pattern.iterator;

/**
 * @类名称:StudentIterator
 * @类描述:抽象迭代器角色接口
 * @包名:behaviour_pattern.iterator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public interface StudentIterator {

    // 判断是否还有元素
    boolean hashNext();

    // 获取下一个元素
    Student next();
}
