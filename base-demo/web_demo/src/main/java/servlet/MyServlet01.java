package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 方式一:  通过实现Servlet接口,创建servlet
 *
 * @Author WangXinWei
 * @Date 2022/2/21 14:31
 * @Version 1.0
 */
public class MyServlet01 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
       // servletResponse.getWriter().print("myServlet01...");
        System.out.println("service in ...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy in ....");
    }
}
