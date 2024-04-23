package com.study.ehcache;

import com.study.CacheApplication;
import com.study.pojo.User;
import com.study.service.UserService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resources;

/**
 * @类名称:EhcacheTest
 * @类描述:ehcache 测试
 * @包名:com.study.ehcache
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-15
 * @版本:V1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CacheApplication.class)
public class EhcacheTest {
    @Autowired
    private UserService userService;

    @Test
    public void ehcache1() {
        // 获取配置
        String absPath = "D:\\project\\base-demo\\spring_cloud_demo\\cache_demo\\src\\main\\resources\\ehcache.xml";

        // 创建cacheManager
        CacheManager cacheManager = CacheManager.create(absPath);

        // 获取一个缓存实例
        Cache userCache = cacheManager.getCache("user_cache");

        // 存入数据
        User user = new User("张三", 2);
        Element element = new Element("1", user);
        userCache.put(element);

        // 获取数据
        Element result = userCache.get("1");
        // [ key = 1, value=User(name=张三, age=2), version=1, hitCount=1,
        // CreationTime = 1710473146055, LastAccessTime = 1710473146071 ]
        System.out.println(result);

        System.out.println("--------------------");
        System.out.println("获取真正的结果:"+result.getObjectValue());

    }

    @Test
    public void ehcache2(){
        User user = userService.getUserId("11");
        System.out.println(user.toString());
        System.out.println("--------------------");
        User user1 = userService.getUserId("11");
        System.out.println(user1.toString());
        System.out.println("--------------------");
        User user2 = userService.getUserId("11");
        System.out.println(user2.toString());

    }

}
