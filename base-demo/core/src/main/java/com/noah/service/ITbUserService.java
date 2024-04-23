package com.noah.service;

import com.github.pagehelper.Page;
import com.noah.common.PaginationFront;
import com.noah.common.PaginationRequest;
import com.noah.domain.TbUser;
import com.noah.req.PageReq;
import com.noah.req.UserInfoAddForm;
import com.noah.req.UserInfoUpdateForm;

import java.util.List;

/**
 * @Author: WangXinWei
 * @Date: 2019/5/30 10:08
 * @Version 1.0
 */
public interface ITbUserService {
    Page<TbUser> getTbUserByID(PaginationRequest<PageReq> pageReq);

    /**
     * 获取全量的user信息
     *
     * @return
     */
    List<TbUser> listTbUser();

    /**
     * 根据ID修改用户信息
     *
     * @param id                 用户ID
     * @param userInfoUpdateForm 更新表单
     */
    void updateUserByID(String id, UserInfoUpdateForm userInfoUpdateForm);

    /**
     * 根据userID获取用户信息
     *
     * @param id userID
     * @return
     */
    TbUser getUserListByID(String id);

    /**
     * 新增用户
     * @param userInfoAddForm   新增用户信息表单
     */
    void addUserInfo(UserInfoAddForm userInfoAddForm);

    /**
     * 删除用户
     * @param id    用户ID
     */
    void deleteUserInfo(String id);

}
