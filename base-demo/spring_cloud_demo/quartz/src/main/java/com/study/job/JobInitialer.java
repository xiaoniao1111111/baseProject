package com.study.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Job任务初始化
 *
 * @Author: WangXinWei
 * @Date: 2019/12/13 10:55
 * @Version 1.0
 */
@Component
@Slf4j
public class JobInitialer {
    @Resource(name = "DemoSchedulerFactory")
    private Scheduler scheduler;

    public void inint(Class<? extends QuartzTest2Job> jobClass, String jobName, String jobGroupName, String cron) {
        // 创建job实例
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName).build();

        // 创建新的trigger触发器
        CronTrigger newTrigger = TriggerBuilder.newTrigger()
                // 组装job名称和组名
                .withIdentity(jobName, jobGroupName)
                // 组装cron表达式(触发规则)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        try {
            boolean exists = scheduler.checkExists(jobDetail.getKey());
            // 任务已存在,比较当前cron表达式是否与旧的一致
            if (exists) {
                log.info("任务已存在:jobName:{},jobGroupName:{}", jobName, jobGroupName);
                // 获取job身份
                TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
                // 根据job身份获取对应的触发器
                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                // 该身份的cron表达式
                String cronExpression = trigger.getCronExpression();
                // 如果cron表达式不一致则用新的cron表达式
                if (!cron.equals(cronExpression)) {
                    log.info("cron表达式发生改变,jobName:{},jobGroupName:{}" + "旧的cron表达式:{}" + "新的cron表达式:{}", jobName, jobGroupName, cronExpression, cron);
                    scheduler.rescheduleJob(triggerKey, newTrigger);
                }
            } else {
                // 如果不存在,则创建新的任务
                log.info("任务不存在则创建新的任务,jobName:{},jobGroupName:{}", jobName, jobGroupName);
                scheduler.scheduleJob(jobDetail, newTrigger);
                // 如果调度器没有启动,则启动
                if (!scheduler.isStarted()) {
                    scheduler.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
