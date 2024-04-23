package com.spring.srping.proxy.jdkproxy;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 15:03
 * @Version 1.0
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        JDKProxyFactory factory = new JDKProxyFactory(customerService);
        CustomerService cust = (CustomerService) factory.getProxyObject();
        cust.find("张三");
        System.out.println("---------------");
        cust.save();
    }
}
