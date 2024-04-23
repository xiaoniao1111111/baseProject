package com.study.servier;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.domain.TbUser;

import java.util.List;

/**
 * @类名称:UserServer
 * @类描述:
 * @包名:com.study.servier
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-19
 * @版本:V1.0.0
 */
public interface UserService {
    /**
     * 根据ID查询用户信息
     *
     * @return
     */
    TbUser getUserById();

    /**
     * 新增用户信息
     *
     * @return
     */
    void insert();

    /**
     * 根据ID更新
     */
    void updateById();

    /**
     * 根据条件构造器中的条件更新
     */
    void updateByWrapper();

    /**
     * 根据条件构造器中的条件更新,不需要实体类
     */
    void updateByWrapper2();

    /**
     * 根据ID删除
     */
    void deleteById();

    /**
     * 通过map的方式传递参数
     */
    void deleteByMap();

    /**
     * 通过条件构造器删除
     */
    void deleteByWrapper();

    /**
     * 批量id删除
     */
    void deleteByIds();

    /**
     * 批量id查询
     *
     * @return
     */
    List<TbUser> getUserByIds();

    /**
     * 分页查询
     */
    IPage<TbUser> pageList();

    /**
     * 通过mybatis读取数据
     *
     * @return
     */
    List<TbUser> selectListByMybatis();

    /**
     * 所有的参数查询
     *
     * @return
     */
    List<TbUser> selectListByAlleq();

    /**
     * 条件or查询
     *
     * @return
     */
    List<TbUser> selectListByOr();

    /**
     * 指定查询字段
     *
     * @return
     */
    List<TbUser> selectListBySelect();

    /**
     * 更新数据时,添加乐观锁
     */
    void updateByVersion();

    /**
     * pageHelper分页插件测试
     */
    void page();
}
