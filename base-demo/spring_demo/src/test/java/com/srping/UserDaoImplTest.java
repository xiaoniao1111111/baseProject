package com.srping;

import com.spring.srping.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author WangXinWei
 * @Date 2022/3/1 18:10
 * @Version 1.0
 */
public class UserDaoImplTest {
    @Test
    public void getUserByNameAndPwd() {
        // DI注入依赖的实现
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        userService.login();
    }
}