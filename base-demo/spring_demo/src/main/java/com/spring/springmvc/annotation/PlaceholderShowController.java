package com.spring.springmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 占位符映射
 * 描述: 在请求路径后面添加参数
 *
 * @Author WangXinWei
 * @Date 2022/3/12 7:16
 * @Version 1.0
 */
@Controller
@RequestMapping("/placeholder")
public class PlaceholderShowController {

    /**
     * 占位符映射
     *
     * @param request
     * @param response
     */
    @GetMapping("/show1/{userName}")
    public void placeholderShow1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("占位符映射...");
    }

    /**
     * 接受请求路径后面的参数
     *
     * 注意: 注解中的参数要和请求路径后面的参数名一致,要不然会接收不到
     *
     * @param request
     * @param response
     */
    @GetMapping("/show2/{userId}/{userName}")
    public void placeholderShow2(HttpServletRequest request, HttpServletResponse response,
                                 @PathVariable("userName") String name,
                                 @PathVariable("userId") String id) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("接收到的参数为: " + id  +"..." + name);
    }
}
