package com.excel.service;

import com.excel.mapper.ResourceMapper;
import com.excel.mapper.UserMapper;
import com.excel.pojo.Resource;
import com.excel.pojo.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserService {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    public List<User> findAll() {
        return userMapper.selectAll();
    }

    public List<User> findPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);  //开启分页
        Page<User> userPage = (Page<User>) userMapper.selectAll(); //实现查询
        return userPage.getResult();
    }

    public User findById(Long id) {
        // 根据ID查询用户,并且用户中附带公共用品数 据
        User user = userMapper.selectByPrimaryKey(id);
        //  再查询办公用品数据
        Resource resource = new Resource();
        resource.setUserId(id);
        List<Resource> resourceList = resourceMapper.select(resource);
        user.setResourceList(resourceList);
        return user;
    }
}
