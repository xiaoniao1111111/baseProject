package com.study.behaviour_pattern.template;

/**
 * 抽象类(定义模板方法和基本方法)
 *
 * @Author: WangXinWei
 * @Date: 2024-02-01-17:25
 * @Version 1.0
 */
public abstract class AbstractClass {

    /**
     * 模板方法定义: 定义他们的执行流程
     */
    public final void cookProcess() {
        pourOil();
        heatOil();
        pourVegetable();
        pourSauce();
        fry();
    }

    /**
     * 第一步: 倒油
     */
    public void pourOil() {
        System.out.println("倒油");
    }

    /**
     * 第二步: 热油
     */
    public void heatOil() {
        System.out.println("热油");
    }

    /**
     * 第三步: 倒蔬菜是不一样的(一个下包菜,一个下菜心)
     */
    public abstract void pourVegetable();

    /**
     * 第四步: 倒入调料是不一样的
     */
    public abstract void pourSauce();

    /**
     * 第五步: 翻炒是一样的
     */
    public void fry() {
        System.out.println("炒啊炒.......");
    }
}
