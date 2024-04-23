package cn.noah.demo.wolfcode.completablefuture_create;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 指定线程池
 * @Author: WangXinWei
 * @Date: 2024-02-03-18:30
 * @Version 1.0
 */
public class RunSyncDemo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 通过lamba表达式创建线程
        CommonUtils.printThreadLog("main start");
        // 通过runAsync创建异步任务
        CompletableFuture.runAsync(()->{
            CommonUtils.printThreadLog("读取文件开始");
            CommonUtils.sleepSecond(3);
            CommonUtils.printThreadLog("读取文件结束");
         },executorService);

        CommonUtils.printThreadLog("没有等待异步执行");
        // 这里睡眠4秒是为了保证异步能执行完成
        CommonUtils.sleepSecond(5);
        CommonUtils.printThreadLog("main end");
    }
}
