package test.idea04;

/**
 * 方法重载测试
 */
public class HeavyLoadTest {
    public static void main(String[] args) {
        // 不同参数类型
        String dog = "小狗";
        int age = 9;
        dog(dog, age);
        dog(age, dog);
        // 不同的个数
        dog(dog, age);
        dog();
    }

    /**
     * 方式重载: 不同参数类型
     *
     * @param dog
     * @param age
     */
    public static void dog(String dog, int age) {
        System.out.println("我的数据类型先string,后int");
    }

    public HeavyLoadTest() {
        super();
    }

    /**
     * 方式重载: 不同参数类型
     *
     * @param age
     * @param dog
     */
    public static void dog(int age, String dog) {
        System.out.println("我的数据类型先int,后string");
    }

    /**
     * 方式重载: 不同个数
     */
    public static void dog() {
        System.out.println("我没有参数");
    }

    ;
}
