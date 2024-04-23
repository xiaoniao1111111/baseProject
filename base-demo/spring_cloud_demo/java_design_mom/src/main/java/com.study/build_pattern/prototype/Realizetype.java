package com.study.build_pattern.prototype;

import java.util.logging.Logger;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-17-14:26
 * @Version 1.0
 */
public class Realizetype implements Cloneable{
    private static Logger logger = Logger.getLogger(String.valueOf(RealizetypeTest.class));
    public Realizetype() {
        logger.info("具体的原型对象创建完成..");
    }
    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        logger.info("具体原型复制成功 ");
        return (Realizetype) super.clone();
    }
}
