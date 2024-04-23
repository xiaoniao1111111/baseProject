package com.spring.srping.instanceBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author WangXinWei
 * @Date 2022/3/2 9:11
 * @Version 1.0
 */
public class Bean4Factory implements FactoryBean<Bean4> {
    @Override
    public Bean4 getObject() throws Exception {
        return new Bean4();
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
