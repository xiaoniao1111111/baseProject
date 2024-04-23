package com.noah.lock;

import com.noah.exception.BizException;

/**
 * @Author: WangXinWei
 * @Date: 2020/1/3 11:27
 * @Version 1.0
 */
public class lockTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String s = setA();
            System.out.println("setB有没有被执行: " + s);
        }
    }

    static synchronized String setA() {
        String threadName = Thread.currentThread().getName();
        String setAMsg = "setA被执行了,该线程名称为: " + threadName;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new BizException("此处睡眠1秒");
        }
        String setBMsg = setB();
        return setAMsg + "<<<<>>>>" + setBMsg;
    }

    static String setB() {
        String threadName = Thread.currentThread().getName();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new BizException("此处睡眠1秒");
        }
        return "setB被执行了,该线程名称为: " + threadName;
    }
}
