package com.spring.srping.service.serviceimpl;

import com.spring.srping.dao.IUserDao;

/**
 * @Author WangXinWei
 * @Date 2022/3/1 16:36
 * @Version 1.0
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public void getUserByNameAndPwd() {
        System.out.println("用户登录了...");
    }
}
