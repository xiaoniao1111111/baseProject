package resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向练习
 *
 * @Author WangXinWei
 * @Date 2022/2/18 7:57
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/myServlet001")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置请求头编码格式
        req.setCharacterEncoding("utf-8");
        // 2. 获取请求参数
        String name = (String) req.getParameter("name");
        // 3. 设置响应头编码格式
        resp.setContentType("text/html;charset=utf-8");
        // 4. 设置请求头中的响应状态码
        resp.setStatus(302);
        // 5. 设置重定向路径及请求参数
        resp.setHeader("location", "/chenServlet001?name=" + name);
    }
}
