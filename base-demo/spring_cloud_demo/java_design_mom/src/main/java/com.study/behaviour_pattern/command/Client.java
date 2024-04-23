package com.study.behaviour_pattern.command;

/**
 * @Author: WangXinWei
 * @Date: 2024-03-04-20:58
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建第一个订单对象
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("西红柿鸡蛋面", 1);
        order1.setFood("小杯可乐", 1);

        // 创建第二个订单对象
        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("尖椒肉丝盖饭", 1);
        order2.setFood("小杯雪碧", 1);

        // 创建接收者对象
        SeniorChef seniorChef = new SeniorChef();
        // 创建命令对象
        OrderCommand orderCommand1 = new OrderCommand(seniorChef, order1);
        OrderCommand orderCommand2 = new OrderCommand(seniorChef, order2);

        // 创建调用者(服务员对象)
        Waitor waitor = new Waitor();
        waitor.setCommand(orderCommand1);
        waitor.setCommand(orderCommand2);

        // 服务员发起命令
        waitor.orderUp();
    }
}
