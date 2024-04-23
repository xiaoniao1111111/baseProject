package test.接口多态09;

/**
 * @Author WangXinWei
 * @Date 2021/4/23 20:28
 * @Version 1.0
 */
public class InterfaceTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        //showAnimalEat(dog);
        //showAnimalEat(cat);
        // 引用数据类型转型
        convertTest();

    }

    /**
     * 类型转换异常
     * 原因: 创建Cat对象以多态的形式向上转型为Animal,但其本身还是Cat对象,当Animal对象向下转型到Dog对象
     * 的时候,该Animal本身还是Cat对象,Cat对象与Dog对象两者没有继承,实现的关系,则在运行时会报出类型转换异常
     * 编译时不会报错
     */
    private static void convertTest() {
        Animal a = new Cat();
        Dog g = (Dog) a;
        g.eat();
    }

    private static void showAnimalEat(Animal animal) {
        animal.eat();
    }
}
