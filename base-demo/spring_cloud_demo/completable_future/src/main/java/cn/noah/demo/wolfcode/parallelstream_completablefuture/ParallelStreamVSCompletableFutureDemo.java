package cn.noah.demo.wolfcode.parallelstream_completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @类名称:ParallelStreamVSCompletableFutureDemo
 * @类描述:并行流于completableFuture比较
 * @包名:cn.noah.demo.wolfcode.parallelstream_completablefuture
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-16
 * @版本:V1.0.0
 */
public class ParallelStreamVSCompletableFutureDemo {
    public static void main(String[] args) {
        // 1.生成0-10数组
        IntStream range = IntStream.range(0, 10);

        // 2.遍历生成对象
        List<MyTask> list = range.mapToObj(item -> {
            return new MyTask(1);
        }).collect(Collectors.toList());

        // 3.串行执行,统计总耗时
        long startTime = System.currentTimeMillis();
        List<Integer> collect = list.stream().map(MyTask::doWork).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("串行遍历,总耗时: " + (endTime - startTime) / 1000 + "秒");

        // 并行流,统计总耗时
        long startTime1 = System.currentTimeMillis();
        List<Integer> collect1 = list.parallelStream().map(MyTask::doWork).collect(Collectors.toList());
        long endTime1 = System.currentTimeMillis();
        System.out.println("并行流,总耗时: " + (endTime1 - startTime1) / 1000 + "秒");

        // completableFuture,总耗时
        // 如果不设置线程池则多一倍的耗时(这里设置线程池)
        // 获取cpu核数
        int cpuCount = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(Math.min(list.size(), cpuCount * 2));
        long startTime2 = System.currentTimeMillis();
        List<CompletableFuture<Integer>> futures = list.stream().map(item -> {
            return CompletableFuture.supplyAsync(item::doWork,threadPool);
        }).collect(Collectors.toList());

        List<Integer> collect2 = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        long endTime2 = System.currentTimeMillis();
        System.out.println("异步编程,总耗时: " + (endTime2 - startTime2) / 1000 + "秒");

        // 关闭线程池
        threadPool.shutdown();
    }
}
