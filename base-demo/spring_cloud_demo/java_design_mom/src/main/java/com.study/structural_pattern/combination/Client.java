package com.study.structural_pattern.combination;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-01-15:46
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建菜单树
        Menu menu1 = new Menu("菜单管理", 2);
        menu1.add(new MenItem("页面访问",3));
        menu1.add(new MenItem("展开菜单",3));
        menu1.add(new MenItem("编辑菜单",3));
        menu1.add(new MenItem("删除菜单",3));
        menu1.add(new MenItem("新增菜单",3));

        Menu menu2 = new Menu("权限管理", 2);
        menu2.add(new MenItem("页面访问",3));
        menu2.add(new MenItem("提交保存",3));

        Menu menu3 = new Menu("角色管理", 2);
        menu3.add(new MenItem("页面访问",3));
        menu3.add(new MenItem("新增角色",3));
        menu3.add(new MenItem("修改角色",3));

        // 创建一级菜单
        MenuComponent component = new Menu("系统管理", 1);
        component.add(menu1);
        component.add(menu2);
        component.add(menu3);

        // 打印菜单名称(如果有子菜单一块打印)
        component.print();
    }
}
