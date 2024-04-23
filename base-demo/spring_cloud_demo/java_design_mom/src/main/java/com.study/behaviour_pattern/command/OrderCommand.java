package com.study.behaviour_pattern.command;

import java.util.Map;
import java.util.Set;

/**
 * @Author: WangXinWei
 * @Date: 2024-03-04-20:51
 * @Version 1.0
 */
public class OrderCommand implements Command {

    // 持有接收者对象
    private SeniorChef seniorChef;

    // 持有订单类
    private Order order;

    public OrderCommand(SeniorChef seniorChef, Order order) {
        this.seniorChef = seniorChef;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单: ");
        Map<String, Integer> fooDir = order.getFooDir();
        Set<String> keys = fooDir.keySet();
        for (String foodName : keys) {
            seniorChef.makeFood(foodName, fooDir.get(foodName));
        }
        System.out.println(order.getDiningTable() + "桌的饭准备完毕");
    }
}
