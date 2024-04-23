package com.noah.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.noah.Application;
import com.noah.req.UserInfoAddForm;
import com.noah.req.UserInfoUpdateForm;
import com.noah.util.MockMVCUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


/**
 * @Author: WangXinWei
 * @Date: 2020/1/13 15:25
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class HelloControllerTest extends MockMVCUtils {
    private static final String baseUrl = "/user";

    /**
     * 根据用户ID获取用户信息-test
     *
     * @throws Exception
     */
    @Test
    public void getUserListByID() throws Exception {
        String url = baseUrl + "/userList/" + 1;
        MockHttpSession session = super.buildSessionUser("小李");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        super.get(url, session, params);
    }

    /**
     * 根据ID更新用户信息-test
     */
    @Test
    public void updateUserByID() throws Exception {
        String id = "2";
        String url = baseUrl + "/insertLock/updateUserByID/" + id;
        MockHttpSession session = super.buildSessionUser("小红");
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("userID", id);
        UserInfoUpdateForm userInfoUpdateForm = new UserInfoUpdateForm();
        userInfoUpdateForm.setUserName("张无忌");
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(userInfoUpdateForm));
        super.put(url, session, multiValueMap, jsonObject);
    }

    /**
     * 新增用户
     *
     * @throws Exception
     */
    @Test
    public void addUserInfo() throws Exception {
        String url = baseUrl + "/addUserInfo/";
        MockHttpSession session = super.buildSessionUser("小绿");
        UserInfoAddForm userInfoAddForm = new UserInfoAddForm();
        userInfoAddForm.setUserName("吕蒙");
        userInfoAddForm.setAge(1);
        userInfoAddForm.setBirthday("2019-01-01");
        userInfoAddForm.setName("小吕蒙");
        userInfoAddForm.setPassword("1234");
        userInfoAddForm.setSex(1);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(userInfoAddForm));
        super.post(url, session, jsonObject);
    }

    /**
     * 删除用户
     *
     * @throws Exception
     */
    @Test
    public void deleteUserInfo() throws Exception {
        String id = "7";
        String url = baseUrl + "/deleteUserInfo/" + id;
        MockHttpSession session = super.buildSessionUser("小伙子");
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("userID", id);
        super.delete(url, session, multiValueMap);
    }
}