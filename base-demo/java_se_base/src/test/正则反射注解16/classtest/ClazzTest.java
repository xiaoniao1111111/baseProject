package test.正则反射注解16.classtest;


import test.正则反射注解16.reflect.Fuit;

/**
 * 获取字节码对象的三种方式
 *
 * @Author WangXinWei
 * @Date 2021/5/11 21:02
 * @Version 1.0
 */
public class ClazzTest {
    /**
     * 类名.class
     */

    public void reflectWayOne() {
        Class<Fuit> fuitClass = Fuit.class;
        // 获取类的相对路径(类的全名)
        String className = fuitClass.getName();
        // 类名
        String simpleName = fuitClass.getSimpleName();
        System.out.println(fuitClass + " 类的相对路径: " + className + " 类名: " + simpleName);
    }

    /**
     * 对象.getClass 反射
     */

    public void reflectWayTwo() {
        Class<? extends Fuit> aClass = new Fuit().getClass();
        System.out.println(aClass);
    }

    /**
     * Class.forName(类的相对路径)
     *
     * @throws ClassNotFoundException
     */

    public void reflectWayThree() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("test.正则反射注解16.reflect.Fuit");
        System.out.println(aClass);
    }

    /**
     * 预定义对象演示
     */

    public void predefineTest() {
        Class<Integer> integerClass = int.class;
        String simpleName = integerClass.getSimpleName();
        System.out.println(simpleName);
    }

}
