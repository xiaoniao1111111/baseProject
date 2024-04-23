package test.ListSet14;

/**
 * 可变参数演示
 *
 * @Author WangXinWei
 * @Date 2022/2/5 12:50
 * @Version 1.0
 */
public class MethodTest {
    public static void main(String[] args) {
        int sum1 = getSum(1, 2, 3);
        int sum3 = changeArgs_01(1, 2, 3);
        int sum2 = changeArgs_02(1, 2, 3);
    }

    private static int getSum(int... num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum;
    }


    /**
     * 1. 可变参数前面可以加参数,但后面不可以跟任何内容,否则报编译错误
     *
     * @param x
     * @param num
     */
    private static int changeArgs_01(int x, int... num) {
        return 0;
    }

    /*    *//*
     * 2. 但后面不可以跟任何内容,否则报编译错误
     *//*
    private static void changeArgs_02(int ...num,int x){

    }*/

    /**
     * 3. 方法重载的时候,有了可变参数,则另一个方法参数列表中就不能是数组了,因为可变参数本身是个数组
     */
    private static int changeArgs_02(int... num) {
        return 0;
    }
/*    private static void changeArgs_02(int[] num) {

    }*/
}
