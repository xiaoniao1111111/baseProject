package com.spring.srping.proxy.jdkproxy;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 14:54
 * @Version 1.0
 */
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void save() {
        System.out.println("保存操作");
    }

    @Override
    public String find(String name) {
        System.out.println("查询操作");
        return name;
    }

}
