package com.study.behaviour_pattern.memento;

/**
 * @类名称:Client
 * @类描述:
 * @包名:behaviour_pattern.memento
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建游戏角色对象
        GameRole gameRole = new GameRole();

        // 初始化状态操作
        gameRole.initState();
        gameRole.stateDisplay();

        // 将该角色内部状态进行备份
        // 创建管理者对象
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveSate());

        System.out.println("----------------大战boss后----------");

        // 损坏严重
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("-------------恢复之前的状态-------------------");
        gameRole.recoverState(roleStateCaretaker.getMemento());
        gameRole.stateDisplay();
    }
}
