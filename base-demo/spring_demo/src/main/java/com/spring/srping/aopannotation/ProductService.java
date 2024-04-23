package com.spring.srping.aopannotation;

import org.springframework.stereotype.Component;

/**
 * @Author WangXinWei
 * @Date 2022/3/10 13:21
 * @Version 1.0
 */
@Component
public class ProductService {
    public  void save(){
        System.out.println("商品保存了....");
    }
    public void find(){
        System.out.println("商品查询数量了....");
    }
}
