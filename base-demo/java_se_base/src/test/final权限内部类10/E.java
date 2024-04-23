package test.final权限内部类10;

/**
 * @Author WangXinWei
 * @Date 2021/4/24 8:36
 * @Version 1.0
 */
public class E { // 外部类
    // 外部类 成员变量
    private final String name = "1";

    // 内部类
    public class F {
        // 内部类 成员变量
        private final String name = "2";

        // 内部类 成员方法
        public  void eat() {
        // 内部类 局部变量
            String name = "3";
            System.out.println("内部类,局部变量 " + name);
            System.out.println("内部类,成员变量 " + this.name);
            System.out.println("外部类,成员变量 " + E.this.name);
        }
    }
}
