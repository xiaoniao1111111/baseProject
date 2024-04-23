package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Author WangXinWei
 * @Date 2022/2/21 17:07
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/deleteCookie")
public class DeleteCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Stream.of(cookies).forEach(cookie -> {
            if (Objects.equals("pwd", cookie.getName())) {
                cookie.setValue(null);
                cookie.setPath("/deleteCookie");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        });
    }
}
