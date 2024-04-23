package com.study.behaviour_pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名称:StudentAggregateImpl
 * @类描述:抽象聚合角色实现类
 * @包名:behaviour_pattern.iterator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class StudentAggregateImpl implements StudentAggregate{
    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
