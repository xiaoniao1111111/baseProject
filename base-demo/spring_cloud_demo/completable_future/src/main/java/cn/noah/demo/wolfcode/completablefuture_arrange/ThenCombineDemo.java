package cn.noah.demo.wolfcode.completablefuture_arrange;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 两个非依赖关系异步编排
 * @Author: WangXinWei
 * @Date: 2024-02-03-22:19
 * @Version 1.0
 */
public class ThenCombineDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("main start");
        // 读取敏感词文件
        CompletableFuture<String[]> filterFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取敏感词文件");
            String s = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\filter_words");
            return s.split(",");
        });

        // 读取文件内容
        CompletableFuture<String> fileFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取敏感词文件");
            return CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
        });

        // 敏感词替换
        CompletableFuture<String> convertFuture = filterFuture.thenCombine(fileFuture, (words, content) -> {
            CommonUtils.printThreadLog("敏感词替换");
            for (String word : words) {
                if (content.indexOf(word) > -1) {
                    content = content.replace(word, "**");
                }
            }
            return content;
        });

        CommonUtils.printThreadLog("主线程运行");
        String s = convertFuture.get();
        CommonUtils.printThreadLog(s);
        CommonUtils.printThreadLog("main end");
    }
}
