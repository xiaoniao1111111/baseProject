package test.动态代理;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author WangXinWei
 * @Date 2022/3/7 18:20
 * @Version 1.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // 1. 获取当前类的加载器
        getCurrClassLoader();
        // 2. 读取src下的配置文件数据
        getSrcProperties();
    }

    private static void getSrcProperties() throws ClassNotFoundException, IOException {
        /**
         * 步骤:
         * 1. 获取properties配置文件对象   new Properties();
         * 2. 获取当前类的类加载器    currClass.getClassLoader();
         * 3. 通过类加载器读取配置源返回一个流   classLoader.getResourceAsStream("person.properties");
         * 4. 通过配置对象加载这个配置流.得到配置数据   p.load(resource);
         * 5. 将配置对象输出到控制台
         */
        Properties p = new Properties();
        Class<?> currClass = Class.forName("test.动态代理.ClassLoaderTest");
        ClassLoader classLoader = currClass.getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("person.properties");
        p.load(resource);
        System.out.println(p);
    }

    private static void getCurrClassLoader() throws ClassNotFoundException {
        Class<?> currClass = Class.forName("test.动态代理.ClassLoaderTest");
        ClassLoader classLoader = currClass.getClassLoader();
        System.out.println(classLoader);
    }
}
