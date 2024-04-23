package com.spring.srping.proxy.cglibproxy;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 15:23
 * @Version 1.0
 */
public class ProductService {
    public void product() {
        System.out.println("生产手机...");
    }

    public String destory(String name) {
        System.out.println("销毁手机..." + name);
        return name;
    }
}
