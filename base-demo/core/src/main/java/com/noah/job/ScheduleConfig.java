package com.noah.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 调度器属性配置
 *
 * @Author: WangXinWei
 * @Date: 2019/12/13 10:40
 * @Version 1.0
 */
@Slf4j
@Configuration
public class ScheduleConfig {
    @Autowired
    private MyJObFactory myJObFactory;
    @Autowired
    private DataSource dataSource;

    @Bean(name = "DemoSchedulerFactory")
    public SchedulerFactoryBean getSchedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 编辑数据源
        schedulerFactoryBean.setDataSource(dataSource);
        // 编辑job工厂
        schedulerFactoryBean.setJobFactory(myJObFactory);
        // 编辑quartz配置
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        return schedulerFactoryBean;
    }

    /**
     * 获取quartz配置属性
     */
    public Properties quartzProperties() {

        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("application.yml"));
        try {
            propertiesFactoryBean.afterPropertiesSet();
            return propertiesFactoryBean.getObject();
        } catch (Exception e) {
            log.error("ScheduleConfig.quartzPropertiesIOException", e);
        }
        return null;
    }
}
