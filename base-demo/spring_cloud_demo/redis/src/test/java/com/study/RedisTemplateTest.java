package com.study;

import com.alibaba.fastjson.JSON;
import com.study.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @类名称:RedisTemplateTest
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-04-22
 * @版本:V1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString() {
        redisTemplate.opsForValue().set("name", "wangwu");
        String value = (String) redisTemplate.opsForValue().get("name");
        System.out.println(value);
    }

    @Test
    public void stringRedisTemplate() {
        String json = JSON.toJSONString(new User("张三", 11));
        stringRedisTemplate.opsForValue().set("user", json);
        String resultJson = stringRedisTemplate.opsForValue().get("user");
        User object = JSON.parseObject(resultJson, User.class);
        System.out.println(object);
    }

    /**
     * hash 操作
     */
    @Test
    public void testHash() {
        stringRedisTemplate.opsForHash().put("fuit", "banana", "1");
        stringRedisTemplate.opsForHash().put("fuit", "apple", "2");
        Map<Object, Object> fuit =stringRedisTemplate.opsForHash().entries("fuit");
        System.out.println(fuit);
        // 11
    }

}
