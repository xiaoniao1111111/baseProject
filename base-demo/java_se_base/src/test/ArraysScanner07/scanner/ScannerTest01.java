package test.ArraysScanner07.scanner;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ScannerTest01 {
    public static void main(String[] args) {
        // 接收一次键盘录入
        //oneScannerTest();
        // 循环接收键盘录入 输入Q退出循环
        // moreScannerTest();
        // 方式二接收用户输入的方式
        scannerNextLineTest();
    }

    /**
     * 方式二: 接收用户输入的方式
     */
    private static void scannerNextLineTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请用户输入信息: ");
        if (scanner.hasNextLine()) {
            String sr = scanner.nextLine();
          //  log.info("该用户输入的信息为:{}", sr);
            System.out.println("该用户输入的信息为: " + sr);
        }
    }

    /**
     * 循环接收键盘录入
     */
    private static void moreScannerTest() {
        // 接收键盘录入
        System.out.println("循环接收用户输入的信息,输入q退出循环");
        Scanner scanner = new Scanner(System.in);
        String sr = null;
        do {
            System.out.print("该用户输入的信息为:");
            if (scanner.hasNext()) {
                sr = scanner.next();
                System.out.println("接收到该用户输入的信息为: " + sr);
            }
        } while (!"q".equals(sr));
        System.out.println("该用户选择退出循环");
    }

    /**
     * 接收一次键盘录入
     */
    private static void oneScannerTest() {
        // 1. System.in: 键盘录入   2. 接受键盘录入的信息(用户输入的信息)
        Scanner scanner = new Scanner(System.in);
        // 输出到控制的信息不换行
        System.out.print("该用户输入的信息为: ");
        // 判断用户有没有输入信息
        if (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println("接收到该用户输入的信息为: " + next);
        }
    }
}
