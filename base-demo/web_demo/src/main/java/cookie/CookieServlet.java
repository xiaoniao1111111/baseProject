package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie演练
 *
 * @Author WangXinWei
 * @Date 2022/2/21 16:27
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/cookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie nameCookie = new Cookie("name", "zhangsan");
        Cookie pwdCookie = new Cookie("pwd", "123");
        nameCookie.setPath("/getCookie");
        pwdCookie.setPath("/deleteCookie");
        nameCookie.setMaxAge(60 * 60 * 24 * 30 * 12);
        pwdCookie.setMaxAge(60 * 60 * 24 * 30 * 12);
        resp.addCookie(nameCookie);
        resp.addCookie(pwdCookie);
    }
}
