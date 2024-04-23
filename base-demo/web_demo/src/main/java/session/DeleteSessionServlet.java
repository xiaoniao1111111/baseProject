package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 删除Session
 *
 * @Author WangXinWei
 * @Date 2022/2/21 17:21
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/deleteSessionServlet")
public class DeleteSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取Session对象
        HttpSession session = req.getSession();
        // 2. 获取SessionID
        String id = session.getId();
        // 3. 获取Cookie对象
        Cookie[] cookies = req.getCookies();
        // 4. 根据SessionID获取当前Cookie
        Stream.of(cookies).forEach(cookie -> {
            if (Objects.equals(id, cookie.getValue())) {
                // 5. 删除Session
                cookie.setValue(null);
                cookie.setPath("/deleteSessionServlet");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        });
    }
}
