package com.study.behaviour_pattern.mediator;

/**
 * @类名称:Client
 * @类描述:
 * @包名:behaviour_pattern.mediator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建中介者对象
        MediatorStructure structure = new MediatorStructure();

        // 创建租房者对象
        Tenant tenant = new Tenant("张三", structure);

        // 创建房主对象
        HouseOwner owner = new HouseOwner("李四", structure);

        // 中介者要知道具体的房主和租房者
        structure.setTenant(tenant);
        structure.setHouseOwner(owner);

        // 租房者和中介沟通
        tenant.constact("我需要一个大大的房子...");
        owner.constact("我这里有大大的房子");
    }
}
