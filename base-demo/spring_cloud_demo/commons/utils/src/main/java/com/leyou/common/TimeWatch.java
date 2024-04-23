package com.leyou.common;

/**
 * 时间工具,用于统计耗时
 *
 * @author WangXinWei
 * @version 1.0
 * @date 2020/12/4 17:39
 */
public class TimeWatch {

    /**
     * 开始时间戳
     */
    private Long startTimestamp;

    /**
     * 获取开始时间戳
     *
     * @return
     */
    public Long getStartTimestamp() {
        return this.startTimestamp = System.currentTimeMillis();
    }

    /**
     * 获取耗时
     * 描述: 结束时间戳-开始时间戳
     */
    public Long getCostTime() {
        // 结束时间戳
        Long endTimestamp = System.currentTimeMillis();
        return endTimestamp - startTimestamp;
    }

    /**
     * 分段统计耗时
     * 描述: 第一段耗时: 在获取到第一段耗时时间戳的时候,记录时间戳作为下一次开始时间戳
     * 第二段耗时: 用当前结束时间戳减去上一段开始时间戳,记录时间戳作为下一次开始时间戳
     * 第三段耗时: 以此类推......
     */
    public Long getCostTimeAndContinue() {
        Long endTimestamp = System.currentTimeMillis();
        Long costTime = endTimestamp - startTimestamp;
        this.startTimestamp = System.currentTimeMillis();
        return costTime;
    }
}
