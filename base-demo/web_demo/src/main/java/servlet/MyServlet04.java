package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过注解代替web.xml中类与请求路径的映射
 *
 * @Author WangXinWei
 * @Date 2022/2/21 15:37
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/myServlet04")
public class MyServlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("myServlet04....");
    }
}
