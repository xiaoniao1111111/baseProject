package test.正则反射注解16.reflect;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射获取构造函数
 *
 * @Author WangXinWei
 * @Date 2021/5/11 21:22
 * @Version 1.0
 */
public class ReflectTest {

    public void getDeclaredConstructor() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        // 获取构造参数对象
       // getConstructor();
        // 获取成员变量及设置成员变量
       // getVariable();
        // 获取成员方法
       // getMethod();
      // 获取静态成员方法
        getStaticMehtod();
    }

    private void getStaticMehtod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> fuitClass = Class.forName("test.正则反射注解16.reflect.Fuit");
        Method show = fuitClass.getDeclaredMethod("show");
        Object invoke = show.invoke(null);
        System.out.println(invoke);
    }

    private void getMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> clss = Class.forName("test.正则反射注解16.reflect.Fuit");
        // 参数1: 方法名  参数2: 方法中的参数类型
        Method method = clss.getDeclaredMethod("save", String.class);
        Fuit fuit = new Fuit();
        // 执行方法  参数1: 具体的对象  参数2: 方法参数 返回结果: 如果该方法没有返回结果,那么返回结果为null
        method.invoke(fuit,"赵四");
    }

    private void getVariable() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // 1. 获取Class对象
        Class<?> fuitClass = Class.forName("test.正则反射注解16.reflect.Fuit");
        // 2. 获取成员变量对象
        Fuit fuit = new Fuit("张三", "11");
        // 参数: 成员属性名
        Field nameObj = fuitClass.getDeclaredField("name");
        // 3. 开启暴力访问(因为private是私有的不能直接访问)
        nameObj.setAccessible(true);
        // 3.给成员变量赋值  参数1: 具体的对象 参数2: 要赋的值
        nameObj.set(fuit,"李四");
        // 5. 获取成员变量  参数: 具体的对象
        String name = (String) nameObj.get(fuit);
        System.out.println(name);
    }

    private void getConstructor() {
        Class<Fuit> fuitClass = Fuit.class;
        try {
        Constructor<Fuit> constructor = fuitClass.getDeclaredConstructor();
        // 通过nweInstance方法创建该类的真实对象
        Fuit fuit = constructor.newInstance();
        System.out.println(constructor);
        System.out.println(fuit.toString());
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
