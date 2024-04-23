package test.异常线程;

/**
 * @Author WangXinWei
 * @Date 2022/2/6 16:25
 * @Version 1.0
 */
public class ExceptionTest {
    public static void main(String[] args) {
        // finally演练
        finallyTest();
    }

    /**
     * finally演练
     */
    private static void finallyTest() {
        int n = 0;
        try {
            if (n == 0) {
                throw new RuntimeException("空指针异常了");
            }
        } catch (Exception e) {
            System.out.println("出现异常了");
        } finally {
            System.out.println("我还是执行了...");
        }
    }
}
