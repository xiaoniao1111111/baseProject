package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 创建Session,设置Session的持久性
 *
 * @Author WangXinWei
 * @Date 2022/2/21 17:13
 * @Version 1.0
 */
@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取Session对象
        HttpSession session = req.getSession();
        // 2. 获取SessionID
        String id = session.getId();
        System.out.println("id = " + id);
        // 3. 设置Session信息
        session.setAttribute("name", "wangwu");
        // 4. 将SessionID放入至Cookie中
        Cookie cookie = new Cookie("JSESSIONID", id);
        // 5. 设置Session的持久性,默认存活时间是: 浏览器关闭,会话结束,也就是cookie失效
        cookie.setPath("/deleteSessionServlet");
        cookie.setMaxAge(60 * 60 * 24 * 30 * 12);
        // 6. 将Cookie放入至响应对象中,返回给客户端
        resp.addCookie(cookie);
    }
}
