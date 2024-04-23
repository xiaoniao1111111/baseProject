package cn.noah.demo.utils;

import static org.junit.Assert.*;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-03-17:42
 * @Version 1.0
 */
public class CommonUtilsTest {

    public static void main(String[] args) {
        String message = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
        CommonUtils.printThreadLog(message);
    }
}