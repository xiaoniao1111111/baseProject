package com.noah.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noah.lock.MysqlLock;
import com.noah.common.PaginationFront;
import com.noah.common.PaginationRequest;
import com.noah.domain.TbUser;
import com.noah.mapper.TbUserMapper;
import com.noah.req.PageReq;
import com.noah.req.UserInfoAddForm;
import com.noah.req.UserInfoUpdateForm;
import com.noah.service.ITbUserService;
import com.noah.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: WangXinWei
 * @Date: 2019/5/30 10:10
 * @Version 1.0
 */
@Slf4j
@Service
public class TbUserServiceImpl implements ITbUserService {
    /**
     * 锁的名称
     */
    private static final String TEST_LOCK = "testLock";
    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private MysqlLock mysqlLock;

    @Override
    public Page<TbUser> getTbUserByID(PaginationRequest<PageReq> pageReq) {
        PageReq data = pageReq.getData();
        Integer age = data.getAge();
        PaginationFront paginationFront = pageReq.getPaginationFront();
        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        tbUserQueryWrapper
                .eq("age", age);
        Page<TbUser> page = PageHelper.startPage(paginationFront.getCurrentPage(), paginationFront.getPageSize())
                .doSelectPage(() -> tbUserMapper.selectList(tbUserQueryWrapper));
        return page;
    }

    /**
     * 获取全量的user信息
     *
     * @return
     */
    @Override
    public List<TbUser> listTbUser() {
        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        List<TbUser> tbUsers = tbUserMapper.selectList(tbUserQueryWrapper);
        return CollectionUtils.isEmpty(tbUsers) ? new ArrayList<>() : tbUsers;
    }

    @Override
    public void updateUserByID(String id, UserInfoUpdateForm userInfoUpdateForm) {
        mysqlLock.getLock(TEST_LOCK);
        try {
            QueryWrapper<TbUser> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("id", "1");
            List<TbUser> tbUsers = tbUserMapper.selectList(userQueryWrapper);
            tbUsers.get(0).setName(userInfoUpdateForm.getUserName());
            tbUserMapper.updateById(tbUsers.get(0));
        } finally {
            mysqlLock.releaseLock(TEST_LOCK);
        }

    }

    @Override
    public TbUser getUserListByID(String id) {
        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        tbUserQueryWrapper.eq("id", id);
        List<TbUser> tbUsers = tbUserMapper.selectList(tbUserQueryWrapper);
        return CollectionUtils.isEmpty(tbUsers) ? new TbUser() : tbUsers.get(0);
    }

    @Override
    public void addUserInfo(UserInfoAddForm userInfoAddForm) {
        TbUser tbUser = new TbUser();
        BeanUtils.copyProperties(userInfoAddForm, tbUser);
        tbUser.setBirthday(DateUtils.stringToDate(userInfoAddForm.getBirthday()));
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUser.setSex("0".equals(userInfoAddForm.getSex()));
        tbUserMapper.insert1(tbUser);
    }

    @Override
    public void deleteUserInfo(String id) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        tbUserMapper.delete(queryWrapper);
    }

}
