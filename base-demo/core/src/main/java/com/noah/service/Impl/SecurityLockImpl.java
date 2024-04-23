package com.noah.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noah.domain.SecurityLock;
import com.noah.mapper.SecurityLockMapper;
import com.noah.service.ISecurityLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WangXinWei
 * @Date: 2020/1/2 17:49
 * @Version 1.0
 */
@Service
public class SecurityLockImpl implements ISecurityLock {
    @Autowired
    private SecurityLockMapper securityLockMapper;

    @Override
    public void insertLock(String lockName) {
        Map<String, Object> paramsMap = new HashMap<>(16);
        paramsMap.put("lockName", lockName);
        securityLockMapper.insertLock(paramsMap);
   /*     SecurityLock securityLock = new SecurityLock();
        securityLock.setLockName(lockName);
        securityLockMapper.insert(securityLock);*/
    }

    @Override
    public void releaseLock(String lockName) {
        QueryWrapper<SecurityLock> lockQueryWrapper = new QueryWrapper<>();
        lockQueryWrapper.eq("LOCK_NAME", lockName);
        securityLockMapper.delete(lockQueryWrapper);
    }
}
