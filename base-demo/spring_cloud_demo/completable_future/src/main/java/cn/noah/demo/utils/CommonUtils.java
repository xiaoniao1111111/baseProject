package cn.noah.demo.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 异步任务辅助工具类
 *
 * @Author: WangXinWei
 * @Date: 2024-02-03-16:41
 * @Version 1.0
 */
public class CommonUtils {

    /**
     * 读取指定文件的路径
     *
     * @param pathToFile
     * @return
     */
    public static String readFile(String pathToFile) {
        try {
            return String.join("", Files.readAllLines(Paths.get(pathToFile)));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 休眠指定的毫秒数
     *
     * @param millis
     */
    public static void sleepMillis(long millis) {
        try {
            TimeUnit.MICROSECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 休眠指定的秒数
     *
     * @param seconds
     */
    public static void sleepSecond(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印输出带线程信息的日志
     *
     * @param message
     */
    public static void printThreadLog(String message) {
        String result = new StringJoiner(" | ")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.format("%2d", Thread.currentThread().getId()))
                .add(String.valueOf(Thread.currentThread().getName()))
                .add(message)
                .toString();
        System.out.println(result);
    }
}
