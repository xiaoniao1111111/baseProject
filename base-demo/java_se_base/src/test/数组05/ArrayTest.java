package test.数组05;

import netscape.javascript.JSObject;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组测试
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 数组格式
       // arrayFormatTest();
        // 获取数组的元素
        //getElement();
        // 获取数组中的最大值
       // getMaxElement();
        // 数组反转
        //arrayReversal();
        // 两个变量指向同一个数组
        // arrayTest();
        // 统计10个1到100之间小于平均数的个数
        //countTest();
        // 将数组中的数据顺序打乱
        randomArr();
    }

    /**
     * 数组格式
     */
    public static void arrayFormatTest() {
        // 数组格式 方式一
        int[] arr1 = new int[2];
        arr1[0] = 1;
        arr1[1] = 2;
        // 数组格式 方式二
        int[] arr2 = new int[]{1, 2, 3};
        // 数组格式 方式三
        int[] arr3 = {1, 2, 3};
    }

    /**
     * 获取数组中的元素
     */
    public static void getElement() {
        int[] arr3 = {1, 2, 3};
        System.out.println("获取数组中的元素: " + arr3[1]);
    }

    /**
     * 获取数组中最大元素
     */
    public static void getMaxElement() {
        int[] arr = {1, 2, 3};
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("获取数组中最大元素: " + max);
    }

    /**
     * 数组反转
     */
    public static void arrayReversal() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int min = 0, max = arr.length - 1; min <= max; min++, max--) {
            int temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 两个变量指向同一个数组
     */
    public static void arrayTest() {
        int[] arr = {1, 2, 3};
        int[] arr2 = arr;
        arr2[0] = 4;
        System.out.println("获取原数组第一个位置的元素: " + arr[0]);
    }

    /**
     * 统计10个1到100之间小于平均数的个数
     *
     * @return
     */
    public static void countTest() {
        // 1.先组装10个1到100的随机数到数组中
        // 1.1定义一个长度为10的数组
        int[] arr = new int[10];
        // 1.2变量10次,将数据放入数组中
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int number = random.nextInt(100) + 1;
            arr[i] = number;
        }
        // 2.求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        // 3.求平均数
        int avg = sum / arr.length;
        // 4.求小于平均数的数字次数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<avg){
                count++;
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println("------");
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("小于平均数的总数为:"+count);
    }

    /**
     * 将数组中的数据顺序打乱
     */
    public static void randomArr() {
        int[] arr = {1, 2, 3, 4, 5};
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int random = r.nextInt(arr.length);
            arr[i] = arr[random];
            arr[random] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
