package com.noah.lock;

import com.noah.exception.BizException;
import com.noah.service.ISecurityLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author: WangXinWei
 * @Date: 2020/1/2 13:38
 * @Version 1.0
 */
@Component
@Slf4j
public class MysqlLock {
    /**
     * 锁的名称
     */
    private static final String TEST_LOCK = "TEST_LOCK";
    /**
     * 获取锁的尝试最大次数
     */
    private static final int TOTAL_COUNT = 50;
    /**
     * 获取锁的间隔，单位毫秒
     */
    private static final int SLEEP_MILLIS = 100;

    @Autowired
    private ISecurityLock securityLock;

    /**
     * 获取锁
     *
     * @param lockName 锁的名称
     */
    public void getLock(String lockName) {
        int count = 1;

        // 如果没有获取到锁，则尝试重新获取；如果尝试了50次都没获取，则放弃
        while (count <= TOTAL_COUNT) {
            boolean flag = doGetLock(lockName, count);
            if (flag) {
                return;
            }

            // 设置睡眠时间,时间一到再次获取锁
            int interval = new Random().nextInt(SLEEP_MILLIS) + 100;
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                log.info("尝试加锁失败,线程休眠{}毫秒!", interval);
            }
            count++;
        }

        throw new BizException("获取锁" + lockName + "失败");
    }

    /**
     * 获取锁
     *
     * @param lockName 锁的名称
     * @param count    尝试获取锁的次数
     * @return
     */
    private Boolean doGetLock(String lockName, int count) {
        // 获取当前线程名称
        String threadName = Thread.currentThread().getName();
        try {
            log.info("当前线程{}第{}次尝试获取锁:{}", threadName, count, lockName);
            securityLock.insertLock(lockName);
            log.info("当前线程{}第{}次成功获取到锁:{}", threadName, count, lockName);
            return true;
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                log.error("当前线程{}第{}次获取锁:{}失败");
                return false;
            }
            throw new BizException("获取锁失败,该锁为:" + lockName, e);
        }

    }

    /**
     * 释放锁
     *
     * @param lockName  锁的名称
     */
    public void releaseLock(String lockName) {
        securityLock.releaseLock(lockName);
    }


}
