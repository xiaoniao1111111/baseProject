package test.final权限内部类10.finalTest;

/**
 * final作用在变量上演示
 *
 * @Author WangXinWei
 * @Date 2021/4/22 22:04
 * @Version 1.0
 */
public class FinalTest {
    public static void main(String[] args) {
        // 作用在变量上
        // 结果: 硬要赋值则报编译错误
        final int a = 1;
        // a = 2;
    }

}
