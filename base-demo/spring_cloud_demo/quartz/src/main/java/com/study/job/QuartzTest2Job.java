package com.study.job;


import com.study.domain.TbUser;
import com.study.service.OrderService;
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
public class QuartzTest2Job extends QuartzJobBean {
    @Autowired
    private JobInitialer jobInitialer;
    @Autowired
    private OrderService orderService;

    @Value("*/5 * * * * ?")  // 每5秒钟执行一次
    private String cron;

    @PostConstruct
    private void init() {
        // job名称(类的名称)
        String simpleName = this.getClass().getSimpleName();
        jobInitialer.inint(this.getClass(), simpleName, "测试Quartz任务", cron);
        log.info("测试Job-Quartz任务初始化完成");
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("测试Job-Quartz任务开始");
        TbUser order = orderService.queryOrderById(1L);
        System.out.println(order.toString());
        log.info("测试Job-Quartz任务结束");
    }


}
