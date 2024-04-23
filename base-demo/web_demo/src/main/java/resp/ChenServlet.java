package resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author WangXinWei
 * @Date 2022/2/18 8:03
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/chenServlet001")
public class ChenServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取重定向后中的请求参数
        String name = (String) req.getParameter("name");
        System.out.println("name = " + name);
        // 处理响应结果
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("成功返回");
    }
}
