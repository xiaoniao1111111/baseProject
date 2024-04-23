package com.spring.srping.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * JDK动态代理工厂
 *
 * @Author WangXinWei
 * @Date 2022/3/8 14:50
 * @Version 1.0
 */
public class JDKProxyFactory implements InvocationHandler {
    private CustomerServiceImpl target;

    public JDKProxyFactory(CustomerServiceImpl target) {
        this.target = target;
    }

    public Object getProxyObject() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Objects.equals(method.getName(), "save")) {
            writeLog();
        }
        return method.invoke(target, args);
    }

    private static void writeLog() {
        System.out.println("记录保存日志");
    }
}
