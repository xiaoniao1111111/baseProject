package cn.noah.demo.wolfcode.completablefuture_getorjoin;

import cn.noah.demo.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @类名称:completablefuture_getorjoin
 * @类描述:获取异步结果:get和join的区别测试
 * @包名:cn.noah.demo.wolfcode
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-16
 * @版本:V1.0.0
 */
public class GetOrJoinDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });

        // join()
        String ret = future.join();
        CommonUtils.printThreadLog(ret);

/*        // get()
        try {
            String ret = future.get();
            CommonUtils.printThreadLog(ret);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }
}
