package com.spring.springmvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring拦截器
 *
 * @Author WangXinWei
 * @Date 2022/3/14 12:44
 * @Version 1.0
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 前置拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("前置方法执行了....");
        // retrun: true: 请求放行,执行业务逻辑   false: 请求拦截,不执行业务逻辑
        return true;
    }

    /**
     * 后置拦截
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws IOException {
        System.out.println("后置方法执行了.....");
    }

    /**
     * 视图渲染完成之后回调方法
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("回调方法执行了.....");
    }
}
