package filter.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author WangXinWei
 * @Date 2022/2/25 14:04
 * @Version 1.0
 */
@WebFilter(urlPatterns = {"/demoFilterEx"})
public class AFilterEx implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AFilterEx in ....");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("AFilterEx end ....");
    }

    @Override
    public void destroy() {

    }
}
