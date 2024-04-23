package cn.noah.demo.wolfcode.parallelstream_completablefuture;

import cn.noah.demo.utils.CommonUtils;

/**
 * @类名称:MyTask
 * @类描述:
 * @包名:cn.noah.demo.wolfcode.parallelstream_completablefuture
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-16
 * @版本:V1.0.0
 */
public class MyTask {
    private int duration;

    public MyTask(int duration) {
        this.duration = duration;
    }

    // 执行任务方法
    public int doWork() {
        CommonUtils.printThreadLog("doWork");
        CommonUtils.sleepSecond(duration);
        return duration;
    }
}
