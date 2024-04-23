package filter.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author WangXinWei
 * @Date 2022/2/25 14:01
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/demoFilterEx")
public class DemoFilterEx extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demoFilterEx in ...");
        resp.getWriter().print("filter success in ....");
    }
}
