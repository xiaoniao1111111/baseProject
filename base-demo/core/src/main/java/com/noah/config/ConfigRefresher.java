/*
package com.noah.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;

import javax.annotation.PostConstruct;
import java.util.Set;

*/
/**
 * @Author: WangXinWei
 * @Date: 2019/7/3 11:23
 * @Version 1.0
 *//*

@Component
public class ConfigRefresher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @ApolloConfig
    private Config config;

    @PostConstruct
    private void initialize() {
        refresher(config.getPropertyNames());
    }

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        refresher(changeEvent.changedKeys());
    }

    private void refresher(Set<String> changeKeys) {
        for (String changeKey : changeKeys) {
            System.out.println("this key is changed:" + changeKey);
        }
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeKeys));
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
*/
