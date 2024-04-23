package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 用于验证拦截器的执行顺序
 *
 * @Author WangXinWei
 * @Date 2022/2/21 20:32
 * @Version 1.0
 */
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter2 ...");
    }

    @Override
    public void destroy() {

    }
}
