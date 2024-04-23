package cn.noah.demo.wolfcode.completablefuture_callback;

import cn.noah.demo.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 返回异步结果,在主线中打印异步结果
 *
 * @Author: WangXinWei
 * @Date: 2024-02-03-19:51
 * @Version 1.0
 */
public class ThenApplyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("main start");
        CompletableFuture<String[]> convertFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取文件信息");
            String s = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
            return s;
        }).thenApply(content -> {
            CommonUtils.printThreadLog("文件转换中.....");
            return content.split(",");
        });

        CommonUtils.printThreadLog("主线程运行中....");
        String[] strings = convertFuture.get();
        CommonUtils.printThreadLog(Arrays.toString(strings));
    }
}
