package com.noah.util;

import com.alibaba.fastjson.JSONObject;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;


/**
 * @Author: WangXinWei
 * @Date: 2020/1/13 14:16
 * @Version 1.0
 */
@AutoConfigureMockMvc(secure = false)
public class MockMVCUtils {
    @Autowired
    private MockMvc mockMvc;

    /**
     * get请求
     *
     * @param url     请求路径
     * @param session 容器
     * @param params  请求参数
     * @return
     * @throws Exception
     */
    public MockHttpServletResponse get(String url, MockHttpSession session, MultiValueMap<String, String> params) throws Exception {

        return this.mockMvc
                // 请求体
                .perform(MockMvcRequestBuilders.get(url).session(session).params(params)
                        // 请求参数类型
                        .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON))
                // 判断接受的状态是否是200
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 打印内容
                .andDo(MockMvcResultHandlers.print())
                // 判断接受类型
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                // 返回值内容判断
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("成功")))
                // json值解析判断
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("200")))
                // 返回MvcResult结果
                .andReturn()
                // 返回响应信息
                .getResponse();
    }

    public MockHttpSession buildSessionUser(String userName) {
        MockHttpSession session = new MockHttpSession();
        // todo 这里需要组装用户的信息(包含:角色,名称,cookie及用户相关的信息)
        session.setAttribute("userName", userName);
        session.setAttribute("role", "经理");
        session.setMaxInactiveInterval(100000);
        return session;
    }

    /**
     * post请求
     *
     * @param url     请求路径
     * @param session 用户容器
     * @param content 请求内容
     * @return
     * @throws Exception
     */
    public MockHttpServletResponse post(String url, MockHttpSession session, JSONObject content) throws Exception {

        return this.mockMvc
                // 请求体
                .perform(MockMvcRequestBuilders.post(url).session(session).content(content.toJSONString())
                        // 请求参数类型
                        .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON))
                // 判断接受的状态是否是200
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 打印内容
                .andDo(MockMvcResultHandlers.print())
                // 判断接受类型
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                // 返回值内容判断
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("成功")))
                // json值解析判断
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("200")))
                // 返回MvcResult结果
                .andReturn()
                // 返回响应信息
                .getResponse();
    }

    /**
     * put请求
     *
     * @param url        请求地址
     * @param session    用户信息
     * @param params     参数请求信息
     * @param jsonObject 方法体请求信息
     * @return
     * @throws Exception
     */
    public MockHttpServletResponse put(String url, MockHttpSession session, MultiValueMap<String, String> params, JSONObject jsonObject) throws Exception {
        return this.mockMvc
                // 请求体
                .perform(MockMvcRequestBuilders.put(url).session(session).params(params)
                        .content(jsonObject.toJSONString())
                        // 请求参数类型
                        .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON))
                // 判断接受的状态是否是200
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 打印内容
                .andDo(MockMvcResultHandlers.print())
                // 判断接受类型
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                // 返回值内容判断
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("成功")))
                // json值解析判断
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("200")))
                // 返回MvcResult结果
                .andReturn()
                // 返回响应信息
                .getResponse();
    }

    /**
     * delete
     *
     * @param url     请求路径
     * @param session 用户信息会话
     * @param params  请求参数
     * @return
     * @throws Exception
     */
    public MockHttpServletResponse delete(String url, MockHttpSession session, MultiValueMap<String, String> params) throws Exception {

        return this.mockMvc
                // 请求体
                .perform(MockMvcRequestBuilders.delete(url).session(session).params(params)
                        // 请求参数类型
                        .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON))
                // 判断接受的状态是否是200
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 打印内容
                .andDo(MockMvcResultHandlers.print())
                // 判断接受类型
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                // 返回值内容判断
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("成功")))
                // json值解析判断
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("200")))
                // 返回MvcResult结果
                .andReturn()
                // 返回响应信息
                .getResponse();
    }

}