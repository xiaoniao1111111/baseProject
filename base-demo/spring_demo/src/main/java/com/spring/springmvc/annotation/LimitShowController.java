package com.spring.springmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 限定请求方法和请求参数演示
 *
 * @Author WangXinWei
 * @Date 2022/3/12 7:35
 * @Version 1.0
 */
@Controller
@RequestMapping("/limit")
public class LimitShowController {
    /**
     * method:限定请求方法
     * RequestMethod.GET: get请求
     * RequestMethod.POST: post请求
     * RequestMethod.PUT: ut请求
     * RequestMethod.DELETE: elete请求
     */
    @RequestMapping(value = "/show/getMethod", method = RequestMethod.GET)
    public void show1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("这是一个get请求...");
    }

    /**
     * params: 请求参数限定
     * 参数中必须带有id参数,要不然会报400(请求参数错误)
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/show2", params = "id") //组合注解,表示这是一个get请求
    public void show2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("参数中必须带有id参数");
    }

    /**
     * 请求中不能包含id参数
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/show3", params = "!id")
    public void show3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("请求中不能包含id参数");
    }

    /**
     * 请求中参数id必须等于1
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/show4", params = "id=1")
    public void show4(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("请求中参数id必须等于1");
    }

    /**
     * 请求中参数id必须不能等于1
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/show5", params = "id!=1")
    public void show5(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("请求中参数id必须不能等于1");
    }

    /**
     * 请求中必须包含参数多个参数
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/show6", params = {"id","name"})
    public void show6(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("请求中必须包含参数多个参数");
    }
}
