package com.spring.srping.proxy.jdkproxy;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 14:53
 * @Version 1.0
 */
public interface CustomerService {
    // 保存方法
    abstract void save();

    // 查询方法
    abstract String find(String name);
}
