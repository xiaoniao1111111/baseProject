package com.spring.srping.service.serviceimpl;

import com.spring.srping.dao.IUserDao;
import com.spring.srping.service.IUserService;

/**
 * @Author WangXinWei
 * @Date 2022/3/1 16:38
 * @Version 1.0
 */
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void login() {
        System.out.println("用户开始登录....");
        // 传统方式获取数据库的信息
   /*     UserDaoImpl userDao = new UserDaoImpl();
        userDao.getUserByNameAndPwd();*/

        // 传统方式的缺点: Dao层和Service层高度耦合
        // spring改动后: 演变一
       /* SpringFactrory factrory = new SpringFactrory();
        IUserDao userDao = (IUserDao)factrory.getUserDao();
        userDao.getUserByNameAndPwd();*/

        // 由spring来管理对象,从配置中获取Dao对象
        /* ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao userDao = (IUserDao) ac.getBean("userDao");
        userDao.getUserByNameAndPwd();*/
        userDao.getUserByNameAndPwd();
    }
}
