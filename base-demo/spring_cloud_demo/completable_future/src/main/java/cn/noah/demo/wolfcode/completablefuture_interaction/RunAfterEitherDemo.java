package cn.noah.demo.wolfcode.completablefuture_interaction;

import cn.noah.demo.utils.CommonUtils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @类名称:RunAfterEitherDemo
 * @类描述:异步交互之runAfterEither测试
 * @包名:cn.noah.demo.wolfcode.completablefuture_interaction
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-16
 * @版本:V1.0.0
 */
public class RunAfterEitherDemo {
    public static void main(String[] args) {
        // 开启任务1
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            int x = new Random().nextInt(3);
            CommonUtils.sleepSecond(x);
            CommonUtils.printThreadLog("任务1耗时: " + x + "秒");
            return x;
        });

        // 开启任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            int x = new Random().nextInt(3);
            CommonUtils.sleepSecond(x);
            CommonUtils.printThreadLog("任务1耗时: " + x + "秒");
            return x;
        });

        CommonUtils.sleepSecond(4);

        task1.runAfterEitherAsync(task2, () -> {
            CommonUtils.printThreadLog("有一个异步任务完成");
        });
    }
}
