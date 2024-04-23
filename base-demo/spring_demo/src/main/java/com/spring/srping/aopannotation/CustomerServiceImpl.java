package com.spring.srping.aopannotation;

import org.springframework.stereotype.Component;

/**
 * @Author WangXinWei
 * @Date 2022/3/10 13:16
 * @Version 1.0
 */
@Component
public class CustomerServiceImpl implements ICustomerService {

    @Override
    public void save() {
        System.out.println("客户保存了....");
    }

    @Override
    public void find() {
      //  int i = 1 / 0;
        System.out.println("客户查询数量了....");
    }
}
