package com.study.structural_pattern.combination;

/**
 * 菜单项类(叶子节点)
 *
 * @Author: WangXinWei
 * @Date: 2024-02-01-15:43
 * @Version 1.0
 */
public class MenItem extends MenuComponent{

    public MenItem(String name,int level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        // 打印菜单项名称
        System.out.println(name);
    }
}
