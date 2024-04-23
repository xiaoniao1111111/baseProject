package com.noah.interceptor.adapter;

import com.noah.interceptor.CSRFRequestInterceptor;
import com.noah.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * 拦截器-适配器
 * @Author: WangXinWei
 * @Date: 2020/1/6 16:22
 * @Version 1.0
 */
@Configuration
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {
  @Autowired
    private CSRFRequestInterceptor csrfRequestInterceptor;
    /**
     * 不需要登录的接口和资源
     */
    public static final List<String> EXCLUDE_PATH_LIST= Arrays.asList(
            // 排除app首页
            // 排除邮件发送接口
            // 排除短信发送接口
            // 排除所有的静态资源
            "/**/*.jsp","/**/*.png","/**/*.jpg","/**/*.css","/**/*.js","/**/*.html",
            "/**/swagger-ui.html/*"
    );

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册防跨站请求拦截器
       registry.addInterceptor(csrfRequestInterceptor).excludePathPatterns(EXCLUDE_PATH_LIST);
    }
}
