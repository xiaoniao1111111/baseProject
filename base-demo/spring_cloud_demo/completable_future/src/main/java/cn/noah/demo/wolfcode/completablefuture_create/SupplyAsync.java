package cn.noah.demo.wolfcode.completablefuture_create;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * 异步创建方式二: supplySync  有返回结果
 *
 * @Author: WangXinWei
 * @Date: 2024-02-03-19:03
 * @Version 1.0
 */
public class SupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
   /*     CommonUtils.printThreadLog("main start");
        // 异步读取文件并返回文件内容
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                CommonUtils.printThreadLog("异步线程读取文件");
                String s = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
                return s;
            }
        });

        CommonUtils.printThreadLog("主线程任务执行中...");
        // 获取异步线程中的结果,并通过主线程进行打印
        String s = future.get(); // 这里会进行阻塞,等待任务执行完毕之后才能获取结果
        CommonUtils.printThreadLog(s);
        CommonUtils.printThreadLog("main end");*/

        // 使用lambda表达式完成
        CommonUtils.printThreadLog("main start");
        // 异步读取文件并返回文件内容
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            CommonUtils.printThreadLog("异步线程读取文件");
            String s = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
            return s;
        });

        CommonUtils.printThreadLog("主线程任务执行中...");
        // 获取异步线程中的结果,并通过主线程进行打印
        String s = future.get(); // 这里会进行阻塞,等待任务执行完毕之后才能获取结果
        CommonUtils.printThreadLog(s);
        CommonUtils.printThreadLog("main end");

    }
}
