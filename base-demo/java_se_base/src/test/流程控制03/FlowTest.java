package test.流程控制03;

import java.util.Arrays;
import java.util.List;

/**
 * 流程控制测试
 */
public class FlowTest {
    public static void main(String[] args) {
        // 顺序结构
        orderTest();

        // 选择结构方式一  if...else
        chooseTest();

        // 选择结构方式二   switch...case(穿透)
        chosseWayTwoTest();

        // 循环结构
        circulationTest();

        // while+break
        circulationTestWayTwo();

        // 嵌套循环跳出整个循环体
        circulationTestWayThree();

        // continue 使用
        continueTest();
    }

    /**
     * 顺序结构测试
     */
    public static void orderTest() {
        int a = 1;
        a += 1;
        int b = a;
        System.out.println("a为: " + a + "...b为: " + b);
    }

    /**
     * 选择结构方式一测试   if...else
     */
    public static void chooseTest() {
        int a = 1;
        if (1 == a) {
            a += 1;
            System.out.println("a = " + a);
        } else {
            System.out.println("a = " + a);
        }
    }

    /**
     * 选择结构方式二测试   switch..case
     */
    public static void chosseWayTwoTest() {
        int i = 1;
        switch (i) {
            case 1:
                System.out.println("结果为: " + 1);

            case 2:
                System.out.println("结果为: " + 2);

            case 3:
                System.out.println("结果为: " + 3);
                break;
            default:
                System.out.println("结果为: " + "其他");
        }
    }

    /**
     * 循环结构测试
     */
    public static void circulationTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i = " + i);
        }
    }

    /**
     * for循环加break
     */
    public static void circulationTestWayTwo() {
        int i = 1;
        while (i < 10) {
            if (i == 3) {
                break;
            }
            i++;
        }
        System.out.println("最后的i为: " + i);
    }

    /**
     * 嵌套循环跳出整个循环体
     */
    public static void circulationTestWayThree() {
        int i=1;
         itheima: while (i<10){
            for (int j = 0; j < 3; j++) {
                System.out.println("j = " + j);
                if (i==3){
                    break itheima;
                }
            }
            i++;
        }
    }

    /**
     * continue 使用
     */
    public static void continueTest() {
        int sum = 0;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.println("获取到该集合奇数的和为: " + sum);
    }

}
