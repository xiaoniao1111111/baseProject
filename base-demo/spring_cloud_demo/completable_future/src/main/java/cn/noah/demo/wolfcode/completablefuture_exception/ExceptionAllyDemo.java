package cn.noah.demo.wolfcode.completablefuture_exception;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-03-23:05
 * @Version 1.0
 */
public class ExceptionAllyDemo {
    public static void main(String[] args) {
        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            return "result1";
        }).thenApply(result -> {
            return result + "result2";
        }).thenApply(result -> {
            String s = null;
            int length = s.length();
            return result + "result3";
        }).exceptionally(ex -> {
            System.out.println("出现异常,异常信息为:" + ex);
            return "空指针";
        });

        String join = exceptionally.join();
        CommonUtils.printThreadLog(join);

    }
}
