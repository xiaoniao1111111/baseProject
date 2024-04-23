package com.spring.srping.instanceBeanBak;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author WangXinWei
 * @Date 2022/3/5 14:25
 * @Version 1.0
 */
public class Bean4BakFactory implements FactoryBean<Bean4Bak>{
    @Override
    public Bean4Bak getObject() throws Exception {
        return new Bean4Bak();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
