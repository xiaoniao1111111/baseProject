package com.study.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @类名称:JobTest
 * @类描述:
 * @包名:com.study.job
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-17
 * @版本:V1.0.0
 */
@Component
@Slf4j
public class JobTest {

    @XxlJob("jobTest")
    public ReturnT<String> jobTest(String msg) {
        log.info("jobTest====>开始执行");
        System.out.println("执行跑批任务.......");
        log.info("jobTest====>执行结束");
        return ReturnT.SUCCESS;
    }
}
