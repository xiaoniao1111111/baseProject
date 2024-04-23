package com.spring.springmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ant风格映射
 *  ? : 通配一个字符
 *  * : 通配一个或多个字符
 *  ** : 通配一个或多个路径
 *
 * @Author WangXinWei
 * @Date 2022/3/12 5:37
 * @Version 1.0
 */
@Controller     // 表示这个是展示层
@RequestMapping("/ant")  //指定这个模块功能作用
public class AntShowController {
    /**
     * GetMapping 获取方法演示
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/antInfo")
    public void getAntInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("hello ant...");
    }

    /**
     *  ? : 通配一个字符
     *  描述: 可以匹配ss后面任意一个字符,但写多个或者不写则不行
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/ss?/antShow1")
    public void antShow1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("ant风格演示:  ? : 通配一个字符");
    }

    /**
     *  通配零个或多个字符
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/ss*/antShow2")
    public void antShow2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("ant风格演示:   * : 通配零个或多个字符              ");
    }

    /**
     *  通配零个或多个路径
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/ss/**/antShow3")
    public void antShow3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("ant风格演示:   ** : 通配零个或多个路径");
    }

}
