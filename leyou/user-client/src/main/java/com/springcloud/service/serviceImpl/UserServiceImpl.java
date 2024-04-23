package com.springcloud.service.serviceImpl;

import com.springcloud.dao.Dao;
import com.springcloud.feign.FeignAPI;
import com.springcloud.pojo.User;
import com.springcloud.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangXinWei
 * @Date 2022/3/18 10:58
 * @Version 1.0
 */

@Service
@Log4j2
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private Dao dao;
    @Autowired
    private FeignAPI feignAPI;

    @Override
    public List<User> getUsers(List<Long> ids) {
        List<User> users = new ArrayList<>();
        // 客户端访问服务端: 传统方式调用
        // users = getWay_01(ids);
        // 客户端访问服务端: Eureka调用
        //users = getEurekaWay(ids, users);
        // 负载均衡方式远程调用
        // users = getRibbon(ids, users);
        // Feign进行远程调用
        users = getFeign(ids, users);
        return users;
    }

    /**
     * Feign远程方式调用
     *
     * @param ids
     * @param users
     * @return
     */
    private List<User> getFeign(List<Long> ids, List<User> users) {
        ids.forEach(id -> {
            users.add(feignAPI.getUser(id));
        });
        return users;
    }

    /**
     * Ribbon(负载均衡)
     * 当Erueka,服务集群时,通过Ribbon(负载均衡)来指定具体哪个服务来接受请求,并响应结果
     *
     * @param ids
     * @param users
     * @return
     */
    private List<User> getRibbon(List<Long> ids, List<User> users) {
        ids.forEach(id -> {
            users.add(restTemplate.getForObject("http://user-service/user/" + id, User.class));
        });
        return users;
    }

    /**
     * Eureka(注册中心)动态获取IP和端口号
     *
     * @param ids
     * @param users
     * @return
     */
    private List<User> getEurekaWay(List<Long> ids, List<User> users) {
        //  获取服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
        // 获取单个服务
        ServiceInstance instance = instances.get(0);
        // 获取IP地址
        String hostName = instance.getHost();
        // 获取端口号
        int port = instance.getPort();
        ids.forEach(id -> {
            users.add(dao.queryUserById(id));
        });
        return users;
    }

    /**
     * 传统方式远程调用
     *
     * @param ids
     * @return
     */
    private List<User> getWay_01(List<Long> ids) {
        List<User> users = new ArrayList<>();
        ids.forEach(id -> {
            users.add(restTemplate.getForObject("http://localhost:80/user/getUser/" + id, User.class));
        });
        return users;
    }
}
