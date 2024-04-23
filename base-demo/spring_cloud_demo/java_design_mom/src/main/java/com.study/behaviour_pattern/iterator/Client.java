package com.study.behaviour_pattern.iterator;

/**
 * @类名称:Client
 * @类描述:
 * @包名:behaviour_pattern.iterator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Client {
    public static void main(String[] args) {
        StudentAggregate studentAggregate = new StudentAggregateImpl();
        studentAggregate.addStudent(new Student("张三","001"));
        studentAggregate.addStudent(new Student("李四","002"));
        studentAggregate.addStudent(new Student("王五","003"));
        studentAggregate.addStudent(new Student("赵六","004"));

        // 遍历聚合对象
        // 1.获取迭代器对象
        StudentIterator iterator = studentAggregate.getStudentIterator();
        // 2.遍历集合
        while (iterator.hashNext()){
            Student next = iterator.next();
            System.out.println(next.toString());
        }
    }
}
