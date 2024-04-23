package test.ArraysScanner07.sting;

/**
 * @Author WangXinWei
 * @Date 2021/4/23 19:41
 * @Version 1.0
 */
public class StringTest {
    public static void main(String[] args) {
        //  String四种构造方式
        // 01. 无参构造
        String s = new String();
        // 02. 字符数组构造
        char[] chars = {'a', 'b', 'c'};
        String strChar = new String(chars);
        // 03. 字节数组构造
        byte[] bytes = {97, 98, 99};
        String strByte = new String(bytes);
        // 04. 字符串构造
        String hello = new String("hello");
    }

}
