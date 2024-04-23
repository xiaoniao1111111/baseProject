package resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向演示
 * @Author WangXinWei
 * @Date 2022/2/21 16:06
 * @Version 1.0
 */
@WebServlet("/redictServlet")
public class RedictServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = false;
        if (flag){
            resp.setStatus(302);
            resp.setHeader("location","/success.html");
        }else {
            resp.setStatus(302);
            resp.sendRedirect("/error.html");
        }
    }
}
