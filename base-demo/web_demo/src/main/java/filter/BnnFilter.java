package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author WangXinWei
 * @Date 2022/2/21 21:03
 * @Version 1.0
 */
@WebFilter(urlPatterns = "/filter001")
public class BnnFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("BnnFilter in .....");
    }

    @Override
    public void destroy() {

    }
}
