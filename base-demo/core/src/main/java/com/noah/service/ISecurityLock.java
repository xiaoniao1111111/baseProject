package com.noah.service;

import java.util.Map;

/**
 * @Author: WangXinWei
 * @Date: 2020/1/2 17:49
 * @Version 1.0
 */
public interface ISecurityLock {
    /**
     * 获取锁(阻塞式+自旋锁)
     *
     * @param lockName 锁名称
     */
    void insertLock(String lockName);

    /**
     * 释放锁(阻塞式+自旋锁)
     *
     * @param lockName 锁名称
     */
    void releaseLock(String lockName);
}
