package com.study.build_pattern.factory.simple_factory;

/**
 * @Author: WangXinWei
 * @Date: 2023/04/26/1:47
 * @Description:
 */
public class FuitFactory {
   Fuit getFuit(String type) {
        if ("苹果".equals(type)){
            return new Apple();
        }else if ("橘子".equals(type)){
            return new Orange();
        }else {
            throw  new RuntimeException("没有当前水果");
        }

    }
}
