package com.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.domain.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wxw
 * @since 2024-03-19
 */
public interface TbUserMapper extends BaseMapper<TbUser> {

    List<TbUser> queryById(@Param("id") Long id);

    /**
     * 查询分页结果
     * @param userName
     * @return
     */
    List<TbUser> selectUserPage(@Param("userName") String userName);
}
