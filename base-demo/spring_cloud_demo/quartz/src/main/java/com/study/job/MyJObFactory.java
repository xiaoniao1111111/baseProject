package com.study.job;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 把JobDetail放入spingIoc容器中
 *
 * @Author: WangXinWei
 * @Date: 2019/12/13 10:30
 * @Version 1.0
 */
@Component
public class MyJObFactory extends AdaptableJobFactory {
    @Resource
    private AutowireCapableBeanFactory factory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的原有的方法创建JobDetail对象
        Object jobDetail = super.createJobInstance(bundle);
        //把JobDetail放入SpringIOC容器中管理
        factory.autowireBean(jobDetail);
        return jobDetail;
    }
}
