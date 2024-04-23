package com.study.behaviour_pattern.iterator;

/**
 * @类名称:StudentAggregate
 * @类描述:抽象聚合角色类
 * @包名:behaviour_pattern.iterator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public interface StudentAggregate {

    // 添加学生功能
    void addStudent(Student student);

    // 删除学生功能
    void removeStudent(Student student);

    // 获取迭代器对象功能
    StudentIterator getStudentIterator();

}
