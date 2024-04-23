package com.study.build_pattern.factory.simple_factory;

/**
 * 水果店
 *
 * @Author: WangXinWei
 * @Date: 2023/04/26/1:50
 * @Description:
 */
public class FuitStore {
    public Fuit getFuit(String type){
        FuitFactory fuitFactory = new FuitFactory();
        return fuitFactory.getFuit(type);
    }
}
