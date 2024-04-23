package com.study.behaviour_pattern.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单类
 *
 * @Author: WangXinWei
 * @Date: 2024-03-04-20:45
 * @Version 1.0
 */
public class Order {
    // 餐桌号码
    private int diningTable;

    // 所下的餐品和份数
    private Map<String, Integer> fooDir = new HashMap<>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFooDir() {
        return fooDir;
    }

    public void setFooDir(Map<String, Integer> fooDir) {
        this.fooDir = fooDir;
    }

    /**
     * 设置餐品和份数
     *
     * @param name
     * @param num
     */
    public void setFood(String name, int num) {
        fooDir.put(name, num);
    }
}
