package com.leyou.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.leyou.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WangXinWei
 * @Date: 2024-02-28-21:29
 * @Version 1.0
 */
@Service
public class RestTemplateImpl {
    @Autowired
    private RestTemplate restTemplate;

    public void getForObject() {
        Map<String, Object> map = new HashMap<>();
        User user = restTemplate.getForObject("www.baidu.com", User.class, map);
    }

    public void getForEntity(){
        Map<String, Object> map = new HashMap<>();
        ResponseEntity<User> userEntity = restTemplate.getForEntity("www.baidu.com", User.class, map);
        // 获取响应码对象
        HttpStatus statusCode = userEntity.getStatusCode();
        // 获取响应码
        int statusCodeValue = userEntity.getStatusCodeValue();
        // 获取结果集
        User body = userEntity.getBody();
    }

    public void postForObject(){
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        User user = restTemplate.postForObject("www.baidu.com", map, User.class);
    }

    public void postForEntityByMap(){
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> map = new HashMap<>();
        HttpEntity<Map<String,Object>> httpEntity = new HttpEntity<>(map,headers);
        ResponseEntity<User> userEntity = restTemplate.postForEntity("www.baidu.com", httpEntity, User.class);
        HttpStatus statusCode = userEntity.getStatusCode();
        int statusCodeValue = userEntity.getStatusCodeValue();
        User body = userEntity.getBody();
    }


    public void postForEntityByObject(){
        HttpHeaders headers = new HttpHeaders();
        User user = new User();
        user.setUserName("张三");
        HttpEntity<User> httpEntity = new HttpEntity<>(user,headers);
        ResponseEntity<User> userEntity = restTemplate.postForEntity("www.baidu.com", httpEntity, User.class);
        HttpStatus statusCode = userEntity.getStatusCode();
        int statusCodeValue = userEntity.getStatusCodeValue();
        User body = userEntity.getBody();
    }

    public void exchangeByObject(){
        User user = new User();
        user.setUserName("张三");
        HttpEntity<User> httpEntity = new HttpEntity<>(user);
        ResponseEntity<User> exchange = restTemplate.exchange("www.baidu.com", HttpMethod.GET, httpEntity, User.class);
        User body = exchange.getBody();
    }

    public void exchangeByMap(){
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(map);
        ResponseEntity<Map> exchange = restTemplate.exchange("www.baidu.com", HttpMethod.POST, httpEntity, Map.class);
        Map body = exchange.getBody();
    }

}
