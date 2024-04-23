package com.study.structural_pattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单类(树枝节点)
 *
 * @Author: WangXinWei
 * @Date: 2024-02-01-15:25
 * @Version 1.0
 */
public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponentList = new ArrayList<>();

    public Menu(String name,int level){
        this.name = name;
        this.level = level;
    }
    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentList.get(index);
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        // 打印菜单名称
        System.out.println(name);

        // 打印子菜单或者子菜单项的名称
        for (MenuComponent menuComponent : menuComponentList) {
            menuComponent.print();
        }
    }
}
