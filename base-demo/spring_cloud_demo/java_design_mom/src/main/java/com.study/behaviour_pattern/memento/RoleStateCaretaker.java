package com.study.behaviour_pattern.memento;

/**
 * @类名称:RoleStateCaretaker
 * @类描述:备忘录对象管理对象
 * @包名:behaviour_pattern.memento
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class RoleStateCaretaker {

    // 声明RoleStateCaretaker类型的变量
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
