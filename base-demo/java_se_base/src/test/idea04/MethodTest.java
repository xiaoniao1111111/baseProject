package test.idea04;

/**
 * 方法的调用方式测试
 *
 */
public class MethodTest {
    public static void main(String[] args) {
        // 方法的调用方式:直接调用
        methodOneTest();
        // 方法的调用方式:赋值调用
        int a = methodTwoTest();
        System.out.println("方法的调用方式:赋值调用 " + a);
        // 方法的调用方式:输出语句调用
        methodStreeTest();
    }

    /**
     * 方法的调用方式:直接调用
     */
    public static void methodOneTest() {
        System.out.println("方法的调用方式:直接调用");
    }

    /**
     * 方法的调用方式:赋值调用
     *
     * @return
     */
    public static int methodTwoTest() {
        return 2;
    }

    /**
     * 方法的调用方式:输出语句调用
     */
    public static void methodStreeTest() {
        System.out.println("方法的调用方式:输出语句调用");
    }
}
