package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 自定义拦截器
 *
 * @Author WangXinWei
 * @Date 2022/2/21 18:16
 * @Version 1.0
 */

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init in ....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("req in...");
        String name = servletRequest.getParameter("name");
        // 添加业务逻辑,是张三则放行,进入具体的请求路径接口,不是张三则拦截请求,处理拦截后的业务逻辑
        System.out.println("filter1 dofilter in ...");
        if (!Objects.equals(name, "zhangsan")) {
            // 放行请求路径
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println(" filter destroy in ....");
    }
}
