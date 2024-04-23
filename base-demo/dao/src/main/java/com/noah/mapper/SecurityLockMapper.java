package com.noah.mapper;

import com.noah.domain.SecurityLock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wxw
 * @since 2020-10-10
 */
public interface SecurityLockMapper extends BaseMapper<SecurityLock> {

    void insertLock(Map<String, Object> paramsMap);
}
