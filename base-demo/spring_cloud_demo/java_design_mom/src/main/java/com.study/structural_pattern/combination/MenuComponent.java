package com.study.structural_pattern.combination;

import lombok.Data;

/**
 * 菜单组件(抽象根节点)
 *
 * @Author: WangXinWei
 * @Date: 2024-02-01-15:15
 * @Version 1.0
 */
public abstract class MenuComponent {
    /**
     * 菜单名称
     */
    protected String name;

    /**
     * 菜单层级
     */
    protected int level;

    /**
     * 菜单本身是没有下级的,所以抛出异常
     *
     * @param menuComponent
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 移除子菜单
     *
     * @param menuComponent
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取指定的子菜单
     *
     * @param index 菜单索引
     * @return
     */
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取菜单或者菜单项的名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 打印菜单名称的方法(包含子菜单和子菜单项)
     */
    public abstract void print();

}
