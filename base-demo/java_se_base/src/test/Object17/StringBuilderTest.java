package test.Object17;

/**
 * @Author WangXinWei
 * @Date 2022/1/22 0:57
 * @Version 1.0
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String s = sb.append(123).append(false).append('c').append("我").toString();
        System.out.println(s);
    }
}
