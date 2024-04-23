package servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 方式二:  通过继承GenericServlet,创建servlet
 *
 * @Author WangXinWei
 * @Date 2022/2/21 15:32
 * @Version 1.0
 */
public class MyServlet02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().print("myServlet02....");
    }
}
