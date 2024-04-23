/*
package com.noah.config;

import com.noah.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

*/
/**
 * @Author: WangXinWei
 * @Date: 2019/5/8 21:50
 * @Version 1.0
 *//*

@Configuration
@Slf4j
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor interceptor;

    */
/**
     * 重写拦截器里面的addInterceptors方法,可以自定义添加拦截器
     *//*

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("有没有拦截");
        //通过registry来注册拦截器,通过addPathPatterns来定义拦截路径
        registry.addInterceptor(interceptor).addPathPatterns("/hello");
    }
}
*/
