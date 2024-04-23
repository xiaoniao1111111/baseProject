package com.study.service.impl;

import com.study.pojo.User;
import com.study.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @类名称:UserServiceImpl
 * @类描述:
 * @包名:com.study.service.impl
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-15
 * @版本:V1.0.0
 */
@CacheConfig(cacheNames = "user_cache")
@Service
public class UserServiceImpl implements UserService {
    @Override
    @Cacheable(key="#id")
    public User getUserId(String id) {
        System.out.println("从数据库中获取数据");
        return new User("张三",12);
    }
}
