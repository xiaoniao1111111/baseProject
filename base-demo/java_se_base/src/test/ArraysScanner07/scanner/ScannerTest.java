package test.ArraysScanner07.scanner;

import java.util.Random;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        // 键盘录入
        // getInfo();
        // 求和
        // sumTest();
        // 最大值
        //maxTest();
        // 获取1到n之间的随机数
        //randomTest();
        // 用户猜数字小游戏
        playGames();

    }

    private static void playGames() {
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int count = 0;
        do {
            if (count == 0) {
                System.out.print("请用户随机输入一个数字: ");
            } else {
                String str = a > x ? "大了" : "小了";
                System.out.println("很遗憾,没有猜中,比猜中的" + str);
                System.out.print("请重新输入一个数字: ");
            }
            a = scanner.nextInt();
            count++;
        } while (x != a);
        System.out.println("太棒啦!恭喜您猜中了");

    }

    private static void randomTest() {
        int n = 20;
        Random random = new Random();
        int x = random.nextInt(n) + 1;
        System.out.println("从1到n之间获取的随机数为: " + x);

    }

    private static void maxTest() {
        System.out.println("求用户输入的最大整数");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请用户输入第一个整数: ");
        int a = scanner.nextInt();
        System.out.print("请用户输入第二个整数: ");
        int b = scanner.nextInt();
        System.out.print("请用户输入第三个整数: ");
        int c = scanner.nextInt();
        int max = a > b ? a : b;
        max = max > c ? max : c;
        System.out.println("用户输入的最大整数为: " + max);
    }

    private static void sumTest() {
        System.out.println("求用户输入两个整数的和");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请用户输入第一个整数: ");
        int a = scanner.nextInt();
        System.out.println("请用户输入第二个整数: ");
        int b = scanner.nextInt();
        System.out.println("用户输入的两个整数和为: " + (a + b));
    }

    public static void getInfo() {
        System.out.print("请用户输入信息: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println("该用户输入的信息为: " + s);
        }
    }
}
