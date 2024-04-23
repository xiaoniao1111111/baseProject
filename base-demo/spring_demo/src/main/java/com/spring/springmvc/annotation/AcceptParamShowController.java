package com.spring.springmvc.annotation;

import com.spring.springmvc.data.Fuit;
import com.spring.springmvc.data.FuitList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接受请求参数
 *
 * @Author WangXinWei
 * @Date 2022/3/12 8:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/accept")
public class AcceptParamShowController {
    /**
     * 接受普通的请求参数
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/show1")
    public void show1(HttpServletRequest request, HttpServletResponse response,
                      /**
                       *  value: 参数名(要和请求路径后面的参数名一致)
                       *  required: 是否为必填字段,默认false
                       *  defaultValue: 给该字段设置一个默认值
                       *  接受基本数据类型,就直接用RequestParam注解即可
                       */
                      @RequestParam(value = "name", required = true) String name) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("接受到的参数为: " + name);
    }

    /**
     * 接受对象
     */
    @GetMapping("/show2")
    public void show2(HttpServletRequest request, HttpServletResponse response,
                      Fuit fuit) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("接受到的参数为: " + fuit.getName() + ":" + fuit.getPrice());
    }

    /**
     * 接受集合
     */
    @GetMapping("/show3")
    public void show3(HttpServletRequest request, HttpServletResponse response,
                      FuitList fuitList) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("接受到的参数为: " + fuitList.toString());
    }

    /**
     * 获取cokieId 复制
     */
    @GetMapping("/show5")
    public void show4(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        Cookie cookie = new Cookie("JSESSIONID", "123456");
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 获取cokieId 复制
     */
    @GetMapping("/show4")
    public void show4(HttpServletRequest request, HttpServletResponse response,
                      @CookieValue("JSESSIONID") String cookieName) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("接受到的cookie为: " + cookieName);
    }

}
