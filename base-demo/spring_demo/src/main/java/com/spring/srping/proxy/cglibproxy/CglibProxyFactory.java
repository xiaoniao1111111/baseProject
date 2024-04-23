package com.spring.srping.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理工厂
 *
 * @Author WangXinWei
 * @Date 2022/3/8 15:13
 * @Version 1.0
 */
public class CglibProxyFactory implements MethodInterceptor {
    private ProductService target;

    public CglibProxyFactory(ProductService target) {
        this.target = target;
    }

    public Object getProxyObject() {
        // 1. 获取代理对象生成器
        Enhancer enhancer = new Enhancer();
        // 2. 设置目标对象
        enhancer.setSuperclass(target.getClass());
        // 3. 设置回调函数
        enhancer.setCallback(this);
        // 4. 创建代理对象并返回
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 对所有方法添加日期章
        writeLog();
        return method.invoke(target, objects);
    }

    private static void writeLog() {
        System.out.println("记录每次操作日志...");
    }
}
