package cn.noah.demo.wolfcode.completablefuture_callback;

import cn.noah.demo.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步回调,并行化
 *
 * @Author: WangXinWei
 * @Date: 2024-02-03-21:39
 * @Version 1.0
 */
public class ThenApplyAsyncDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CommonUtils.printThreadLog("main start");
        CompletableFuture<String[]> fileFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取文件");
            String s = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
            return s;
        }).thenApplyAsync((content) -> {
            CommonUtils.printThreadLog("读取文件成功");
            return content.split(",");
        }, executorService);
        CommonUtils.printThreadLog("主线程运行");
        String[] strings = fileFuture.get();
        executorService.shutdown();
        CommonUtils.printThreadLog(Arrays.toString(strings));
        CommonUtils.printThreadLog("main end");
    }
}
