package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 方式二:  通过继承HttpServlet,创建servlet
 * @Author WangXinWei
 * @Date 2022/2/21 15:35
 * @Version 1.0
 */
public class MyServlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("myServlet03...");
    }
}
