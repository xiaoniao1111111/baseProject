package cn.noah.demo.wolfcode.completablefuture_create;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 * 异步创建方式一: runSync  无返回结果
 * @Author: WangXinWei
 * @Date: 2024-02-03-18:30
 * @Version 1.0
 */
public class RunSyncDemo {
    public static void main(String[] args) {
/*        // 开启一个异步任务读取文件
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                CommonUtils.printThreadLog("读取文件开始");
                CommonUtils.sleepSecond(3);
                CommonUtils.printThreadLog("读取文件结束");
            }
        });

        // completableFuture 中的异步任务底层通过开启线程的方式完成的*/

 /*       CommonUtils.printThreadLog("main start");
        // 通过runAsync创建异步任务
        CompletableFuture.runAsync(
                // 匿名内部类创建线程
                new Runnable() {
            @Override
            public void run() {
                CommonUtils.printThreadLog("读取文件开始");
                CommonUtils.sleepSecond(3);
                CommonUtils.printThreadLog("读取文件结束");
            }
        });

        CommonUtils.printThreadLog("没有等待异步执行");
        // 这里睡眠4秒是为了保证异步能执行完成
        CommonUtils.sleepSecond(5);
        CommonUtils.printThreadLog("main end");
        */
        /**********************************************************************/
        // 通过lamba表达式创建线程
        CommonUtils.printThreadLog("main start");
        // 通过runAsync创建异步任务
        CompletableFuture.runAsync(()->{
            CommonUtils.printThreadLog("读取文件开始");
            CommonUtils.sleepSecond(3);
            CommonUtils.printThreadLog("读取文件结束");
         });

        CommonUtils.printThreadLog("没有等待异步执行");
        // 这里睡眠4秒是为了保证异步能执行完成
        CommonUtils.sleepSecond(5);
        CommonUtils.printThreadLog("main end");
    }
}
