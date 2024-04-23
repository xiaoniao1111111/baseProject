package com.study.behaviour_pattern.mediator;

import java.util.Objects;

/**
 * @类名称:MediatorStructure
 * @类描述:具体中介者角色类
 * @包名:behaviour_pattern.mediator
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class MediatorStructure extends Mediator{

    // 聚合租房者和房主
    private HouseOwner houseOwner;

    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void constact(String message, Person person) {
        if (Objects.equals(person,houseOwner)){
            // 如果是房主,则租房者获取房屋的信息
            tenant.getMessage(message);
        }else {
            // 如果是租房者,则租房者的信息传递进来
            houseOwner.getMessage(message);
        }
    }
}
