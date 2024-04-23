package com.study.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis连接池配置
 * 创建连接池,在连接池中创建redis连接对象,对外提供redis对象方法
 *
 * @类名称:JedisConnectionFactory
 * @类描述:
 * @包名:com.study.jedis.util
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-04-22
 * @版本:V1.0.0
 */
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    // jedisPool初始化
    static {
        // 配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(8);
        // 最大空闲连接数
        jedisPoolConfig.setMaxIdle(8);
        // 最小空闲连接数
        jedisPoolConfig.setMinIdle(0);
        // 当连接池中没有连接可用的时候,我们要不要等待,等多长时间,默认-1(也就是没有连接时无线等待,直到有空闲的连接为止)
        jedisPoolConfig.setMaxWaitMillis(1000); // 单位: 毫秒
        // 创建连接池对象
        jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379, 1000);
    }

    /**
     * 获取Jedis对象
     *
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
