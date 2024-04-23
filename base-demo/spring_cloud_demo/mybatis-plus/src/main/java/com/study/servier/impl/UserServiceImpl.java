package com.study.servier.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.domain.TbUser;
import com.study.mapper.TbUserMapper;
import com.study.servier.UserService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类名称:UserServerImpl
 * @类描述:
 * @包名:com.study.servier.impl
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-19
 * @版本:V1.0.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 当前页
     */
    public static final Integer DEFAULT_PAGE_NUM = 1;
    /**
     * 当前页条数
     */
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public TbUser getUserById() {

        List<TbUser> userList = userMapper.selectList(new QueryWrapper<TbUser>().eq("id", 1));
        return userMapper.selectOne(new QueryWrapper<TbUser>().eq("id", 1));
    }

    @Override
    public void insert() {
        TbUser tbUser = new TbUser();
        tbUser.setUserName("李四");
        tbUser.setAddress("中国");
        int insert = userMapper.insert(tbUser);
        System.out.println("返回的结果:" + insert);
        Long id = tbUser.getId();
        System.out.println("主键ID为:" + id);
    }

    @Override
    public void updateById() {
        TbUser tbUser = new TbUser();
        tbUser.setId(2L);
        tbUser.setUserName("李六");
        tbUser.setAddress("中国1");
        int insert = userMapper.updateById(tbUser);
        System.out.println("返回的结果:" + insert);
    }

    @Override
    public void updateByWrapper() {
        TbUser tbUser = new TbUser();
        tbUser.setId(2L);
        tbUser.setUserName("李1");
        tbUser.setAddress("中1");
        QueryWrapper<TbUser> wrapper = new QueryWrapper<TbUser>()
                .eq("id", 2);
        int insert = userMapper.update(tbUser, wrapper);
        System.out.println("返回的结果:" + insert);
    }

    @Override
    public void updateByWrapper2() {
        UpdateWrapper<TbUser> updateWrapper = new UpdateWrapper<TbUser>()
                .set("province", "南京省").set("city", "南京市")
                .eq("user_name", "李1");
        int insert = userMapper.update(null, updateWrapper);
        System.out.println("返回的结果:" + insert);
    }

    @Override
    public void deleteById() {
        int insert = userMapper.deleteById(2L);
        System.out.println("返回的结果:" + insert);
    }

    @Override
    public void deleteByMap() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_name", "李四");
        paramMap.put("address", "中国");
        int insert = userMapper.deleteByMap(paramMap);
        System.out.println("返回的结果:" + insert);
    }

    @Override
    public void deleteByWrapper() {
        QueryWrapper<TbUser> deleteWapper = new QueryWrapper<TbUser>()
                .eq("user_name", "李四").eq("address", "中国");
        int insert = userMapper.delete(deleteWapper);
        System.out.println("返回的结果:" + insert);
    }

    @Override
    public void deleteByIds() {
        int insert = userMapper.deleteBatchIds(Arrays.asList(10, 11, 12));
        System.out.println("返回的结果:" + insert);
    }

    @Override
    public List<TbUser> getUserByIds() {
        return userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
    }


    @Override
    public IPage<TbUser> pageList() {
        QueryWrapper<TbUser> wrapper = new QueryWrapper<TbUser>().like("user_name", "四");
        Page<TbUser> page = new Page<>(1, 10);
        return userMapper.selectPage(page, wrapper);
    }

    @Override
    public List<TbUser> selectListByMybatis() {
        return userMapper.queryById(1L);
    }

    @Override
    public List<TbUser> selectListByAlleq() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_name", "李四");
        paramMap.put("address", "中国");
        QueryWrapper<TbUser> wrapper = new QueryWrapper<TbUser>().allEq(paramMap);
        return userMapper.selectList(wrapper);
    }

    @Override
    public List<TbUser> selectListByOr() {
        return userMapper.selectList(new QueryWrapper<TbUser>()
                .eq("user_name", "张三")
                .or()
                .eq("address", "中国"));
    }

    @Override
    public List<TbUser> selectListBySelect() {
        return userMapper.selectList(new QueryWrapper<TbUser>()
                .eq("user_name", "张三")
                .select("id", "user_name", "city"));
    }

    @Override
    public void updateByVersion() {
        TbUser tbUser = new TbUser();
        tbUser.setUserName("王liu");
        tbUser.setVersion(1);
        QueryWrapper<TbUser> wrapper = new QueryWrapper<TbUser>().eq("id", 9L);
        userMapper.update(tbUser,wrapper);
    }

    @Override
    public void page() {
        String userName = "四";
        PageHelper.startPage(DEFAULT_PAGE_NUM, DEFAULT_PAGE_SIZE);
        List<TbUser> userList1 = userMapper.selectUserPage(userName);
        PageInfo<TbUser> pageInfo = new PageInfo<>(userList1);
        List<TbUser> list = pageInfo.getList();
        System.out.println(list.toString());
    }

}
