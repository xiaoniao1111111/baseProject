package cn.noah.demo.wolfcode.future_vs_completablefuture;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-03-17:52
 * @Version 1.0
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //  功能: 读取文件,并将文件中的敏感词替换为**
        // 1.创建固定线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 2.读取敏感词汇
        Future<String[]> filterFuture = executor.submit(() -> {
            String file = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\filter_words");
            String[] split = file.split(",");
            return split;
        });

        // 3.读取文章内容
        Future<String> newsFuture = executor.submit(() -> {
            String file = CommonUtils.readFile("D:\\project\\base-demo\\spring_cloud_demo\\completable_future\\src\\main\\resources\\news.txt");
            return file;
        });

        // 4.将文章中的敏感词替换为**
        Future<String> replaceFuture = executor.submit(() -> {
            String[] filterStr = filterFuture.get();
            String newsContent = newsFuture.get();
            for (String filter : filterStr) {
                if (newsContent.indexOf(filter) >= 0) {
                    newsContent = newsContent.replace(filter, "**");
                }
            }
            return newsContent;
        });

        // 5. 打印输出替换后的文章
        String message = replaceFuture.get();
        CommonUtils.printThreadLog(message);

    }
}
