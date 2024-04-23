package cn.noah.demo.wolfcode.completablefuture_callback;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-03-21:12
 * @Version 1.0
 */
public class ThenRunDemo {
    public static void main(String[] args) {
        CommonUtils.printThreadLog("main start");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            String s = "";
            CommonUtils.printThreadLog("读取文件");
            CommonUtils.sleepSecond(1);
            s=CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
            return s;
        },executorService).thenRun(()->{
            CommonUtils.printThreadLog("读取文件成功");
        });

        CommonUtils.printThreadLog("主线程运行");
        CommonUtils.sleepSecond(10);
        CommonUtils.printThreadLog("main end");
    }
}
