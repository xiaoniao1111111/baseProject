package com.spring.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 获取request body中的内容工具类
 *
 * @Author: WangXinWei
 * @Date: 2019/12/24 10:14
 * @Version 1.0
 */
@Slf4j
public class HttpRequestUtil {
    public static String getBodyContent(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = request.getReader()) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            log.error("获取请求内容失败", e);
            throw new RuntimeException("获取请求内容失败", e);
        }

        return sb.toString();
    }
}
