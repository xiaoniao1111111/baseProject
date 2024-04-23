
package com.spring.srping.lifeCycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * @Author WangXinWei
 * @Date 2022/3/5 16:49
 * @Version 1.0
 */

@Component("lifeCycleBean")
public class LifeCycleBean {
    public LifeCycleBean() {
        System.out.println("bean实例化了....");
    }

    // 实例化对象时,调用初始化方法注解
    @PostConstruct
    public void init() {
        System.out.println("bean初始化了....");
    }

    // 实例化对象时,调用销毁方法注解
    @PreDestroy
    public void distory() {
        System.out.println("bean被销毁了...");
    }
}

