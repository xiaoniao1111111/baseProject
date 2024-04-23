package test.异常线程.String拼接;

/**
 * @author Wang Xin Wei
 * @version 1.0
 * @date : 2022-06-14 21:07
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";

        StringBuilder1 stringBuilder1 = new StringBuilder1( s1);

        StringBuilder1 stringBuilder2 = new StringBuilder1(s2);

        StringBuilder1 stringBuilder3 = new StringBuilder1(s3);
        stringBuilder1.start();
        stringBuilder2.start();
        stringBuilder3.start();

    }
}
