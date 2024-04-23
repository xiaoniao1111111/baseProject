package com.noah.job;


import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 执行定时任务
 *
 * @Author: WangXinWei
 * @Date: 2019/12/13 13:33
 * @Version 1.0
 */
@Component
@DisallowConcurrentExecution //禁止并发地执行同一个job定义 (JobDetail定义的)的多个实例。
@Slf4j
public class QuartzTestJob extends QuartzJobBean {
    @Autowired
    private JobInitialer jobInitialer;

    @Value("0 0 12 * * ?")
    private String cron;

    @PostConstruct
    private void init() {
        // job名称(类的名称)
        String simpleName = this.getClass().getSimpleName();
        jobInitialer.inint(this.getClass(), simpleName, "测试Job-Quartz任务", cron);
        log.info("测试Job-Quartz任务初始化完成");
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("测试Job-Quartz任务开始");
        System.out.println("测试Job-Quartz任务执行成功");
        log.info("测试Job-Quartz任务结束");
    }


}
