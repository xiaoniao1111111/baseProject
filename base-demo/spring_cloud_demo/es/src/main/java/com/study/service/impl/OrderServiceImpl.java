package com.study.service.impl;

import com.study.domain.TbUser;
import com.study.mapper.TbUserMapper;
import com.study.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类名称:OrderServiceImpl
 * @类描述:
 * @包名:com.study.service.impl
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-15
 * @版本:V1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public TbUser queryOrderById(long id) {
        TbUser tbUser = new TbUser();
        tbUser.setId(id);
        return  userMapper.selectOne(tbUser);
    }
}
