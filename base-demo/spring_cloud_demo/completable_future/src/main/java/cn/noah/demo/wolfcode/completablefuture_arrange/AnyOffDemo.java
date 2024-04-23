package cn.noah.demo.wolfcode.completablefuture_arrange;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @Author: WangXinWei
 * @Date: 2024-02-03-22:55
 * @Version 1.0
 */
public class AnyOffDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.sleepSecond(2);
            return "Future1的结果";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.sleepSecond(1);
            return "Future2的结果";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.sleepSecond(3);
            return "Future3的结果";
        });

        CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2, future3);
        String join = future.join().toString();
        CommonUtils.printThreadLog(join);

    }
}
