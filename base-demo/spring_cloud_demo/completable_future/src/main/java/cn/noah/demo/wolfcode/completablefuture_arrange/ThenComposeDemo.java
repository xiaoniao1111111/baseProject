package cn.noah.demo.wolfcode.completablefuture_arrange;

import cn.noah.demo.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * 两个有依赖关系异步编排
 *
 * @Author: WangXinWei
 * @Date: 2024-02-03-21:56
 * @Version 1.0
 */
public class ThenComposeDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CommonUtils.printThreadLog("main start");
        CompletableFuture<String[]> convertFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取文件");
            return CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
        }).thenComposeAsync(content -> {
            return CompletableFuture.supplyAsync(() -> {
                CommonUtils.printThreadLog("文件转换");
                return content.split(",");
            }, executorService);
        });

        CommonUtils.printThreadLog("主线程运行");
        String[] s = convertFuture.get();
        executorService.shutdown();
        CommonUtils.printThreadLog(Arrays.toString(s));
    }
}
