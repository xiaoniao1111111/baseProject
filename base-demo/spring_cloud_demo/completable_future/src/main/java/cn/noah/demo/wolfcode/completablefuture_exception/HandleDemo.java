package cn.noah.demo.wolfcode.completablefuture_exception;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-03-23:19
 * @Version 1.0
 */
public class HandleDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return "result1";
        }).handleAsync((result, ex) -> {
            if (ex != null) {
                CommonUtils.printThreadLog("出现异常: " + ex.getMessage());
                return "Unknown1";
            }
            return result;
        }).thenApply(reuslt -> {
            String s = null;
            int length = s.length();
            return reuslt + " result2";
        }).handleAsync((result, ex) -> {
            if (ex != null) {
                CommonUtils.printThreadLog("出现异常: " + ex.getMessage());
                return "Unknown2";
            }
            return result + " result3";
        });

        String join = future.join();
        CommonUtils.printThreadLog(join);
    }
}
