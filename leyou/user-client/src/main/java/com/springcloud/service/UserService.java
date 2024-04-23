package com.springcloud.service;

import com.springcloud.pojo.User;

import java.util.List;

/**
 * @Author WangXinWei
 * @Date 2022/3/18 10:57
 * @Version 1.0
 */
public interface UserService {
    List<User> getUsers(List<Long> ids);
}
