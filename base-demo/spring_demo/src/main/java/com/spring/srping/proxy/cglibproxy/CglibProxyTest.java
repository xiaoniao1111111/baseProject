package com.spring.srping.proxy.cglibproxy;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 14:50
 * @Version 1.0
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        ProductService target = new ProductService();
        CglibProxyFactory factory = new CglibProxyFactory(target);
        ProductService productService = (ProductService) factory.getProxyObject();
        productService.product();
        System.out.println("--------------------");
        String name = productService.destory("小米");
        System.out.println(name);
    }

}
