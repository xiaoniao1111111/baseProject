package cn.noah.demo.wolfcode.completablefuture_callback;

import cn.noah.demo.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 将返回的异步结果进行处理/打印
 *
 * @Author: WangXinWei
 * @Date: 2024-02-03-20:02
 * @Version 1.0
 */
public class ThenAcceptDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("main start");
        CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取文件信息");
            String s = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
            return s;
            // 异步结果集转换
        }).thenApply(content -> {
            CommonUtils.printThreadLog("文件转换中.....");
            return content.split(",");
            // 打印回调函数结果集
        }).thenAccept(convertContent -> {
            CommonUtils.printThreadLog("转换后的结果为:" + Arrays.toString(convertContent));
        });

        CommonUtils.printThreadLog("主线程运行中....");
        CommonUtils.sleepSecond(4);
        CommonUtils.printThreadLog("main end");
    }
}
