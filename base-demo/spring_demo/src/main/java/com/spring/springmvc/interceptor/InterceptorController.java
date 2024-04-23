package com.spring.springmvc.interceptor;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author WangXinWei
 * @Date 2022/3/14 12:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {
    @GetMapping("/get")
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("业务逻辑执行了...");
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("视图渲染了....");
    }

    @PostMapping("/save")
    public void save(@RequestBody String name){
        System.out.println(name);
    }
}
