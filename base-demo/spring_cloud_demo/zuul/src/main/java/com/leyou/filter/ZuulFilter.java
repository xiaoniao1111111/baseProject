package com.leyou.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author WangXinWei
 * @Date 2022/3/21 12:21
 * @Version 1.0
 */
@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
    /**
     * filterType: 过滤类型
     * pre: 请求在被路由之前调用
     * routing: 在路由请求时调用
     * post: 在routing和Error过滤器之后调用
     * error: 处理请求时发生错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 返回一个int值,用来指定过滤器执行顺序,数字越小优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回boolean值,判断该过滤器是否执行,true: 执行,false: 不执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 1.获取上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 2.从上下文中获取request对象
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        // 3.获取鉴权参数
        String paizi = request.getParameter("token");
        if (Objects.isNull(paizi) || StringUtils.isEmpty(paizi)) {
            // 鉴权失败,没有发现token,登录效验失败,拦截
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
        }
        // 4. 鉴权成功,放行
        return null;
    }
}
