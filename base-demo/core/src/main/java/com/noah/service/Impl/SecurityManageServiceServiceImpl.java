
package com.noah.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noah.domain.SecurityManage;
import com.noah.mapper.SecurityManageMapper;
import com.noah.service.ISecurityManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: WangXinWei
 * @Date: 2020/1/6 17:58
 * @Version 1.0
 */

@Service
public class SecurityManageServiceServiceImpl implements ISecurityManageService {
    @Autowired
    private SecurityManageMapper securityManageMapper;

    @Override
    public Map<Integer, Integer> getTypeStatusMap(List singletonList) {
        QueryWrapper<SecurityManage> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("security_type", singletonList);
        return securityManageMapper.selectList(queryWrapper).stream().collect(Collectors.toMap(SecurityManage::getSecurityType, SecurityManage::getEnableStatus));
    }
}
