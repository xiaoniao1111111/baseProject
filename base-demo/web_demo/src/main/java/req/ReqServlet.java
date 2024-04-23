package req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * @Author WangXinWei
 * @Date 2022/2/21 15:41
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/reqServlet")
public class ReqServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求报文
        // 获取请求行
        getReqRow(req);
        // 获取请求头
        // 通过KEY获取Value,这里就不写了
        // 获取请求体
        getReqBody(req);
        // 请求转发演练
        String parameter = req.getParameter("name");
        req.setAttribute("name",parameter);
        req.getRequestDispatcher("/forwardServlet").forward(req,resp);

    }

    private void getReqBody(HttpServletRequest req) {
        // 获取字符类型的参数
        String parameter = req.getParameter("name");
        System.out.println("parameter = " + parameter);
        // 获取数组类型的参数
        String[] names = req.getParameterValues("name");
        Stream.of(names).forEach(System.out::println);
    }

    private void getReqRow(HttpServletRequest req) {
        // 请求方式
        String method = req.getMethod();
        System.out.println("method = " + method);
        // url
        String url = req.getRequestURI();
        System.out.println("url = " + url);
        // ip
        String ip = req.getRemoteAddr();
        System.out.println("ip = " + ip);
        // 协议/版本
        String protocol = req.getProtocol();
        System.out.println("protocol = " + protocol);
    }
}
