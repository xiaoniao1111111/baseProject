package com.noah.interceptor;

import com.alibaba.fastjson.JSON;
import com.noah.common.BaseResponse;
import com.noah.enumeration.BaseRespEnum;
import com.noah.enumeration.EnableEnum;
import com.noah.enumeration.SecurityEnum;
import com.noah.service.ISecurityManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import tk.mybatis.mapper.genid.GenId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;

/**
 * 防跨站请求拦截器
 *
 * @Author: WangXinWei
 * @Date: 2020/1/6 17:16
 * @Version 1.0
 */
@Component
@Slf4j
public class CSRFRequestInterceptor implements HandlerInterceptor {
    @Autowired
    private ISecurityManageService securityManageService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<Integer, Integer> typeStatusMap = securityManageService.getTypeStatusMap(Collections.singletonList(SecurityEnum.CSRF.getType()));

        // 是否不开启,直接放行
        Integer status = typeStatusMap.get(SecurityEnum.CSRF.getType());
        if (status != null && status.equals(EnableEnum.DISABLE.getType())) {
            log.info("当前CSRF功能已禁用");
            return true;
        }

        // referer 请求头实现防盗链
        StringBuffer requestURL = request.getRequestURL();
        String uri = request.getRequestURI();
        String requestSource = requestURL.substring(0, requestURL.indexOf(uri));
        // 获取请求从哪里来的
        String referer = request.getHeader("referer");
        // 如果是输入的地址或者从别的网站重定向到本网站的地址则为false
        if (!StringUtils.isEmpty(referer) && referer.startsWith(requestSource)) {
            return true;
        }
        log.info("CSRFRequestInterceptor拦截了URL为:{},uri为:{},referer为:{}的请求", requestURL, uri, referer);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write(JSON.toJSONString(new BaseResponse(BaseRespEnum.REFERER_INVALID.getCode(), BaseRespEnum.REFERER_INVALID.getMessage(), (Object) null)));
        pw.flush();
        pw.close();
        return false;
    }
}
