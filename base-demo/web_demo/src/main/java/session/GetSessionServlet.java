package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 获取Session信息
 * @Author WangXinWei
 * @Date 2022/2/21 17:20
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/getSessionServlet")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取Session对象
        HttpSession session = req.getSession();
        // 2. 获取Session信息
        String name = (String) session.getAttribute("name");
        // 3. 将信息返回至客户端
        resp.getWriter().print(name);
    }
}
