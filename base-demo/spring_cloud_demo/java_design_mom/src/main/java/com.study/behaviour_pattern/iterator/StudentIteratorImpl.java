package com.study.behaviour_pattern.iterator;

import java.util.List;

/**
 * @类名称:StudentIteratorImpl
 * @类描述:
 * @包名:behaviour_pattern.iterator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class StudentIteratorImpl implements StudentIterator {

    private List<Student> studentList;

    private int position = 0;

    public StudentIteratorImpl(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hashNext() {
        return position < studentList.size();
    }

    @Override
    public Student next() {
        Student student = studentList.get(position);
        position++;
        return student;
    }
}
