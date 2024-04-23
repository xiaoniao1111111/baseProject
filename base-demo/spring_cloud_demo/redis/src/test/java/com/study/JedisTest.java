package com.study;

import com.study.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @类名称:JedisTest
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-04-22
 * @版本:V1.0.0
 */
public class JedisTest {
    private Jedis jedis;

    /**
     * jedis建立连接
     */
    @BeforeEach
    void step() {
        // 1.建立连接
        jedis = JedisConnectionFactory.getJedis();
        // 2.设置密码
        // 3.选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name", "胡歌");
        System.out.println(result);
        String value = jedis.get("name");
        System.out.println("value: " + value);
    }

    /**
     * 关闭连接
     */
    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * hash操作
     */
    @Test
    void testHash() {
        jedis.hset("user1", "name", "张三");
        jedis.hset("user1", "age", "12");
        Map<String, String> map = jedis.hgetAll("user1");
        System.out.println(map);
    }
}
