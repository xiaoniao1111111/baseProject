package test.数据类型02;

/**
 * 字符和数值互转
 */
public class TransitonTest {
    public static void main(String[] args) {
        // 字符转成数值  隐式转换
        int i = 'A';
        System.out.println("'A'转换后的数值为: " + i);
        // 数值转成字符   强制转换
        char a=(char)98;
        System.out.println("93对应的字符为:"+a);

        //大写字母转成小写字母
        char b=(char)('A'+32);
        System.out.println("大写字母转成小写字母" + b);
    }
}
