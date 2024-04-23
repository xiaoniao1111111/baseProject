package test.正则反射注解16.regex;

/**
 * 正则表达式单元测试
 *
 * @Author WangXinWei
 * @Date 2021/5/11 20:43
 * @Version 1.0
 */
public class RegexTest {
    public static void main(String[] args) {
        // 判断该字符串是否是12
        String regex = "12";
        String s = "12";
        boolean matches = s.matches(regex);
        System.out.println(matches);
    }
}
