package test.动态代理;

import test.动态代理.proxymode.LiuYan;
import test.动态代理.proxymode.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @Author WangXinWei
 * @Date 2022/3/7 17:50
 * @Version 1.0
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
        // 1. 通过Proxy类生成一个代理对象
        // 1.1 参数1: 获取被代理对象的类加载器,来作为参数中的加载器
         LiuYan liuYan = new LiuYan();
        ClassLoader classLoader = liuYan.getClass().getClassLoader();
        // 1.2 参数2: 获取代理对象和被代理对象共同的接口类,通过代理对象来获取
        Class<?>[] interfaces = liuYan.getClass().getInterfaces();
        // 1.3 参数3: 代理处理器(InvocationHandler ).本身是个接口,通过匿名内部类处理
        InvocationHandler h = new InvocationHandler() {
            // 在这个方法中对被代理对象进行拦截,修改参数处理
            // 参数1: 代理对象 参数2: 调用的方法  参数3: 调用方法中的参数列表
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 1) 根据调用不同的方法来处理不同的逻辑
                // 获取方法名及参数中的值
                String methodName = method.getName();
                // 调用的是saving方法
                if (Objects.equals("saving",methodName)){
                    double money = (double) args[0];
                    if (money<2000){
                        System.out.println("钱太少,拒绝...");
                        return null;
                    }
                    System.out.println("唱歌:王五抽取了" + money * 0.2 + "元...");
                    liuYan.saving(money * 0.8);
                    return null;
                }
                // 调用的是liveShow方法
                if (Objects.equals("liveShow",methodName)){
                    double money = (double) args[0];
                    if (money<3000){
                        System.out.println("钱太少,拒绝...");
                        return null;
                    }
                    System.out.println("参加真人秀:王五抽取了" + money * 0.2 + "元...");
                    liuYan.saving(money * 0.8);
                    return null;
                }
                liuYan.sleep();
                return null;
            }
        };
        Star proxy = (Star)Proxy.newProxyInstance(classLoader, interfaces, h);
        // 2. 被代理对象调用各种方法
        proxy.saving(2000.00);
        System.out.println("---------------------");
        proxy.liveShow(1000.00);
        System.out.println("---------------------");
        proxy.sleep();
    }
}
