package com.study.caffeine;

import com.github.benmanes.caffeine.cache.*;
import com.study.CacheApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @类名称:CaffeineTest
 * @类描述:caffeine 缓存测试
 * @包名:com.study.caffeine
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-14
 * @版本:V1.0.0
 */
@Slf4j
public class CaffeineTest {
    /**
     * 缓存: get方式获取数据,若key不存在则自行返回处理值
     */
    @Test
    public void cahe1() {
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(10) //  最大缓存数
                .expireAfterWrite(3L, TimeUnit.SECONDS) // 失效时间
                .build();

        cache.put("1", "张三");
        String value = cache.get("1", (key) -> {
            log.info("如果获取不到,自行处理....");
            return "get方式: " + key;
        });
        System.out.println(value);
    }

    /**
     * 缓存: CacheLoader方式获取数据,如key不存在,则从缓存加载中获取数据
     */
    @Test
    public void cahe2() {
        LoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(10) //  最大缓存数
                .expireAfterWrite(3L, TimeUnit.SECONDS) // 失效时间
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        log.info("从缓存中获取数据....");

                        return "缓存加载: " + key;
                    }
                });

        cache.put("1", "张三");
        for (Map.Entry<String, String> entry : cache.getAll(Arrays.asList("1", "2", "3")).entrySet()) {
            log.info("获取到的key: " + entry.getKey() + ";value: " + entry.getValue());
        }

    }

    /**
     * 异步缓存
     */
    @Test
    public void cahe3() {
        AsyncLoadingCache<String, String> cache = null;
        try {
            cache = Caffeine.newBuilder()
                    .maximumSize(10) //  最大缓存数
                    .expireAfterWrite(3L, TimeUnit.SECONDS) // 失效时间
                    .buildAsync((key, exector) ->
                            // 异步处理缓存加载
                            CompletableFuture.supplyAsync(() -> {
                                log.info("异步缓存加载....");
                                return "Async" + key;
                            })
                    );
            cache.put("1", CompletableFuture.supplyAsync(() -> "张三"));
            TimeUnit.SECONDS.sleep(5L);
            cache.put("2", CompletableFuture.supplyAsync(() -> "李四"));
            for (Map.Entry<String, String> entry : cache.getAll(Arrays.asList("1", "2", "3")).get().entrySet()) {
                log.info("获取到的key: " + entry.getKey() + ";value: " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 驱逐策略: 缓存容量驱逐
     */
    @Test
    public void cahe4() throws InterruptedException {
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(3) //  最大缓存数
                .expireAfterWrite(10L, TimeUnit.SECONDS) // 失效时间
                .build();

        cache.put("1", "张三1");
        cache.put("2", "张三2");
        cache.put("3", "张三3");
        cache.put("4", "张三4");
        TimeUnit.SECONDS.sleep(3l);
        String value = cache.get("1", (key) -> key);
        String value1 = cache.get("2", (key) -> key);
        String value2 = cache.get("3", (key) -> key);
        String value3 = cache.get("4", (key) -> key);
        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }

    /**
     * 驱逐策略: 缓存权重驱逐策略
     */
    @Test
    public void cahe5() throws InterruptedException {
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumWeight(60L)
                .weigher((key,value)->{
                    log.info("[权重计算]key{},value{}",key,value);
                    return 20;
                })
                .expireAfterWrite(10L, TimeUnit.SECONDS) // 失效时间
                .build();

        cache.put("1", "张三1");
        cache.put("2", "张三2");
        cache.put("3", "张三3");
        cache.put("4", "张三4");
        TimeUnit.SECONDS.sleep(3l);
        String value = cache.get("1", (key) -> key);
        String value1 = cache.get("2", (key) -> key);
        String value2 = cache.get("3", (key) -> key);
        String value3 = cache.get("4", (key) -> key);
        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }

    /**
     * 驱逐策略: 时间驱逐策略
     */
    @Test
    public void cahe6() throws InterruptedException {
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(50)
                .expireAfterWrite(2L, TimeUnit.SECONDS) // 失效时间
                .build();

        cache.put("1", "张三1");
        cache.put("2", "张三2");
        cache.put("3", "张三3");
        cache.put("4", "张三4");
        String startValue = cache.get("1", (key) -> key);
        System.out.println(startValue);
        TimeUnit.SECONDS.sleep(3l);
        String value = cache.get("1", (key) -> key);
        String value1 = cache.get("2", (key) -> key);
        String value2 = cache.get("3", (key) -> key);
        String value3 = cache.get("4", (key) -> key);
        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}
