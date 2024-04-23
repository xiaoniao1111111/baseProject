package test.ArraysScanner07.random;

import java.util.Random;
import java.util.Scanner;

public class RandomTest01 {
    public static void main(String[] args) {
        // 获取1-10之间随机数
        getRandomTest();
        // 猜数字游戏
        guessNumGame();

    }

    /**
     * 猜数字游戏
     * 规则: 1. 1-100之间获取随机数    2. 用户随意输入
     * 3. 用户猜错,告诉用户离猜中是大还是小,继续重新猜  4. 猜中结束游戏
     */
    private static void guessNumGame() {
        Boolean flag = false;
        // 1. 随机一个幸运数字
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        System.out.println("幸运数字为: " + x);
        // 2. 用户输入数字
        Scanner scanner = new Scanner(System.in);
        // 3. 设置循环体: 先猜再判断  do....while
        do {
            System.out.print("该用户这次输入的是: ");
            if (scanner.hasNext()) {
                String sr = scanner.next();
                // 4. 与猜中的数字进行比较,并告知猜大了还是猜小了
                if (x > Integer.valueOf(sr)) {
                    System.out.println("很遗憾,您猜错了,比猜中的小了");
                } else if (x < Integer.valueOf(sr)) {
                    System.out.println("很遗憾您猜错了,比猜中的大了");
                } else {
                    System.out.println("恭喜您猜中了!!!!");
                    flag = Boolean.TRUE;
                }
            }
            // 5. 设置一个标识,猜错继续猜,猜对结束循环体
        } while (!flag);

    }

    /**
     * 获取1-10之间随机数
     */
    public static void getRandomTest() {
        Random random = new Random();
        int x = random.nextInt(10) + 1;
        System.out.println("1-10之间的随机数为: " + x);
    }
}
