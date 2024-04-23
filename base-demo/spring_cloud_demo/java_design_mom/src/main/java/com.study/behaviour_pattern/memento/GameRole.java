package com.study.behaviour_pattern.memento;

/**
 * @类名称:GameRole
 * @类描述:游戏角色类(发起人角色)
 * @包名:behaviour_pattern.memento
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class GameRole {
    private int vit; // 生命力
    private int atk; // 攻击力
    private int def; // 防御力

    // 初始化内部状态
    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    // 定义一个战斗的方法
    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    // 保存角色状态功能
    public Memento saveSate() {
        return new RoleStateMemento(vit, atk, def);
    }

    // 恢复角色初始化状态
    public void recoverState(Memento memento) {
        RoleStateMemento roleStateMemento = (RoleStateMemento) memento;
        this.vit = roleStateMemento.vit;
        this.atk = roleStateMemento.atk;
        this.def = roleStateMemento.def;
    }

    // 展示内部状态
    public void stateDisplay() {
        System.out.println("角色生命力:" + vit);
        System.out.println("角色攻击力:" + atk);
        System.out.println("角色防御力:" + def);
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    private class RoleStateMemento implements Memento {
        private int vit; // 生命力
        private int atk; // 攻击力
        private int def; // 防御力

        public RoleStateMemento(int vit, int atk, int def) {
            this.vit = vit;
            this.atk = atk;
            this.def = def;
        }
    }
}
