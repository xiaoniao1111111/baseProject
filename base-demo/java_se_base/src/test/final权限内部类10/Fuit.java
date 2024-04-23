package test.final权限内部类10;

/**
 * 成员变量初始化的两种方式
 * @Author WangXinWei
 * @Date 2021/4/22 22:16
 * @Version 1.0
 */
public class Fuit {
    // 方式一直接赋值
    private final String userName = "张三";
    private String age;
    // 方式二；private final String userName   在这里加上userName参数
    public Fuit(String age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
