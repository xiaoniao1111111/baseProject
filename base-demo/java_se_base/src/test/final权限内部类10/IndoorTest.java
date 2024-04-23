package test.final权限内部类10;

/**
 * @Author WangXinWei
 * @Date 2021/4/24 8:45
 * @Version 1.0
 */
public class IndoorTest {
    public static void main(String[] args) {
        E e = new E();
        E.F f = e.new F();
        f.eat();
        // 匿名内部类演示
        new K() {
            @Override
            public void eat() {

            }
        };
    }
}
