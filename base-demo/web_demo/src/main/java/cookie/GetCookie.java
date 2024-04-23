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
 * @Date 2022/2/21 17:04
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/getCookie")
public class GetCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        // 设置CookieValue
        Stream.of(cookies).forEach(cookie -> {
            if (Objects.equals("name",cookie.getName())){
                cookie.setValue("lisi");
                cookie.setPath("/getCookie");
                cookie.setMaxAge(60*60);
                resp.addCookie(cookie);
            }});
    }
}
