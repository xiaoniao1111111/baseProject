package req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发,接受转发参数,并返回结果
 *
 * @Author WangXinWei
 * @Date 2022/2/21 15:50
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/forwardServlet")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = true;
        if (flag) {
            req.getRequestDispatcher("/success.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("/error.html").forward(req, resp);
        }
    }
}
