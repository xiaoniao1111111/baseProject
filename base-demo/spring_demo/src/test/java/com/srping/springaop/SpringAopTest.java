package com.srping.springaop;

import com.spring.srping.aopannotation.ICustomerService;
import com.spring.srping.aopannotation.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Aop通知注解测试
 * 前置通知,后置通知,环绕通知,抛出通知,最终通知
 *
 * @Author WangXinWei
 * @Date 2022/3/10 13:23
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringAopTest {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ProductService productService;


    @Test
    public void aopAnnotation() {
        customerService.find();
        customerService.save();
        System.out.println("---------------");
        productService.find();
        productService.save();
    }
}
