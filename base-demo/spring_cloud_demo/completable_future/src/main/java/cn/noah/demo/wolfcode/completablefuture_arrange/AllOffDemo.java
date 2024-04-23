package cn.noah.demo.wolfcode.completablefuture_arrange;

import cn.noah.demo.utils.CommonUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * 多个异步任务编排
 *
 * @Author: WangXinWei
 * @Date: 2024-02-03-22:31
 * @Version 1.0
 */
public class AllOffDemo {

    public static CompletableFuture<String> readFile(String fileName) {
        return CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取文件");
            return CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\" + fileName);
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 需求: 统计所有文件中含有completableFuture的文件个数

        // 1: 获取文件名数组
        List<String> strings = Arrays.asList("news1", "news2", "news3");

        // 2: 获取所有文件
        List<CompletableFuture<String>> collect = strings.stream().map(fileName -> {
            return readFile(fileName);
        }).collect(Collectors.toList());

        // 3: 把list转换成 CompletableFuture[],方便传入allOf方法中
        int size = collect.size();
        CompletableFuture[] array = collect.toArray(new CompletableFuture[size]);

        // 4: 使用allOf方法合并多个异步任务
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(array);

        // 5: 当多个异步任务完成后,使用回调文件结果,统计符合条件的文件个数
        CompletableFuture<Long> fileCount = voidCompletableFuture.thenApply(v -> {
            return collect.stream().map(future -> {
                return future.join();
            }).filter(content -> content.contains("completableFuture")).count();
        });

        // 6: 通过主线程打印异步结果
        Long count = fileCount.get();
        CommonUtils.printThreadLog(count.toString());
    }
}
