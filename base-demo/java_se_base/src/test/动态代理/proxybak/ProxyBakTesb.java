package test.动态代理.proxybak;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 10:11
 * @Version 1.0
 */
public class ProxyBakTesb {
    public static void main(String[] args) {
        // 1. 获取代理对象类
        XiaoWang xiaoWang = new XiaoWang();
        Class<? extends XiaoWang> aClass = xiaoWang.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        // 2. 获取他们共同的接口类(通过被代理对象来获取)
        Class<?>[] interfaces = aClass.getInterfaces();
        // 3. 获取动态代理处理器(通过匿名内部类来处理动态代理逻辑)
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 苹果
                String name = method.getName();
                if (Objects.equals(name, "applePrice")) {
                    Double price = (Double) args[0];
                    if (price < 10) {
                        System.out.println("太少不要了....");
                        return null;
                    }
                    System.out.println("动态代理,中间拿走" + price * 0.2 + "颗苹果");
                    xiaoWang.applePrice(price * 0.8);
                    return null;
                }
                // 香蕉
                if (Objects.equals(name, "bananaPrice")) {
                    Double price = (Double) args[0];
                    if (price > 1000) {
                        System.out.println("太多不要了....");
                        return null;
                    }
                    System.out.println("动态代理,中间拿走" + price * 0.2 + "个香蕉");
                    xiaoWang.applePrice(price * 0.8);
                    return null;
                }
                // 梨
                Double price = (Double) args[0];
                System.out.println("动态代理,不喜欢吃梨...");
                xiaoWang.applePrice(price);
                return null;
            }
        };
        Fuit fuit = (Fuit) Proxy.newProxyInstance(classLoader, interfaces, h);
        fuit.applePrice(11.0);
        System.out.println("--------------");
        fuit.bananaPrice(1100.0);
        System.out.println("--------------");
        fuit.pearPrice(1.0);
    }
}
