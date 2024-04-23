package filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于验证请求路径的匹配方式
 *
 * @Author WangXinWei
 * @Date 2022/2/21 20:46
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/demoFilter/b")
public class DemoFilter2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("demoFilter b.... ");
    }
}
