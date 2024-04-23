package test.正则反射注解16.reflectbak;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 9:48
 * @Version 1.0
 */
public class ReflectBakTest {
    public static void main(String[] args) throws Exception {
        // 获取类的三种方式
        //getClassWay();
        // 反射获取构造参数
        //getConstrutor();
        // 反射获取成员变量
        //getMemberVariables();
        // 反射成员方法
       // getMethod01();
        // 反射获取静态成员方法
        getStaticMethod();
    }

    private static void getStaticMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> aClass = Class.forName("test.正则反射注解16.reflectbak.FuitBak");
        Method method = aClass.getDeclaredMethod("save", String.class);
        Object invoke = method.invoke(null, "小吴");
        System.out.println("invoke = " + invoke);
    }

    private static void getMethod01() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        FuitBak fuitBak = new FuitBak();
        Class<?> aClass = Class.forName("test.正则反射注解16.reflectbak.FuitBak");
        Method method = aClass.getDeclaredMethod("save");
        Object invoke = method.invoke(fuitBak);
        System.out.println(invoke);
    }

    private static void getMemberVariables() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> aClass = Class.forName("test.正则反射注解16.reflectbak.FuitBak");
        FuitBak fuitBak = new FuitBak();
        Field field = aClass.getDeclaredField("name");
        // 暴力访问
        field.setAccessible(true);
        field.set(fuitBak, "小航");
        Object o = field.get(fuitBak);
        System.out.println(o);
    }

    private static void getConstrutor() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        Class<?> aClass = Class.forName("test.正则反射注解16.reflectbak.FuitBak");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, Double.class);
        FuitBak fuitBak = (FuitBak) constructor.newInstance("张三", 1.00);
        System.out.println(fuitBak.toString());
    }

    private static void getClassWay() throws ClassNotFoundException {
        Class<FuitBak> fuitBakClass = FuitBak.class;
        FuitBak fuitBak = new FuitBak();
        Class<? extends FuitBak> aClass = fuitBak.getClass();
        Class<?> aClass1 = Class.forName("test.正则反射注解16.reflectbak.FuitBak");
    }
}
