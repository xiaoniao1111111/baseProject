package filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @Author WangXinWei
 * @Date 2022/2/21 19:32
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/demoFilter/a")
public class DemoFilter extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("filter success...");
    }
}
