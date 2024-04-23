package com.study.guava_cache;

import com.google.common.cache.*;
import com.study.CacheApplication;
import com.study.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @类名称:GuavaCacheTest
 * @类描述:
 * @包名:PACKAGE_NAME
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CacheApplication.class)
public class GuavaCacheTest {

    /**
     * 简单缓存使用,通过get()方法获取,获取不到则通过lambda表达式获取
     *
     * @throws ExecutionException
     */
    @Test
    public void method() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .initialCapacity(5) //初始化容量
                .maximumSize(10) // 最大缓存数,超出淘汰
                .expireAfterWrite(60, TimeUnit.SECONDS) // 过期时间
                .build();

        String orderId = "123456";
        // 获取订单数据,如果key不在,则调用getInfo方法获取数据
        String s = cache.get(orderId, () -> {
            return getInfo(orderId);
        });
        System.out.println(s);
    }

    private static String getInfo(String orderId) {
        return "456";
    }


    /**
     * 如果当前key获取不到,则从缓存中加载
     */
    @Test
    public void method2() throws InterruptedException {
        LoadingCache<String, User> cache = CacheBuilder.newBuilder()
                .initialCapacity(5) //初始化容量
                .maximumSize(10) // 最大缓存数,超出淘汰
                .expireAfterWrite(3, TimeUnit.SECONDS) // 过期时间
                .removalListener(new RemovalListener<String, User>() { // 对移除的数据进行监听
                    @Override
                    public void onRemoval(RemovalNotification<String, User> removalNotification) {
                        String key = removalNotification.getKey();
                        RemovalCause cause = removalNotification.getCause();
                        System.out.println("key:" + key + "被缓存删除的原因:" + cause);
                    }
                })
                .build(new CacheLoader<String, User>() {
                    @Override
                    public User load(String key) throws Exception {
                        System.out.println("从缓存中加载....");
                        return new User("java缓存加载" + key, 22);
                    }
                });

        for (int i = 0; i < 10; i++) {
            User user = cache.getUnchecked("22");
            System.out.println(user.toString());
            TimeUnit.SECONDS.sleep(1L);
        }

    }

}
