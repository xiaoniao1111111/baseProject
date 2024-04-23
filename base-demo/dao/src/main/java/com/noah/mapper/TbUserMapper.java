package com.noah.mapper;

import com.noah.domain.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wxw
 * @since 2022-02-25
 */
public interface TbUserMapper extends BaseMapper<TbUser> {

    List<TbUser> queryUserById(@Param("id")Long id);

    void insert1(TbUser tbUser);
}
