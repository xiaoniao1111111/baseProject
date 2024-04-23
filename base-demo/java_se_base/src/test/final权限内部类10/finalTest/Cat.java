package test.final权限内部类10.finalTest;

/**
 * @author Wang Xin Wei
 * @version 1.0
 * @date : 2022-06-14 17:54
 */
public class Cat {
    // 被final修饰的方法演示
    // 结果: 该方法是不能被复写的,硬写则报编译错误
    final void eat(String fund) {
        System.out.printf("吃" + fund);
    }

    void price(Double b) {
        System.out.println("价格: " + b);
    }
}
