package resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author WangXinWei
 * @Date 2022/2/18 6:59
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/getResponse")
public class ResponseServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应报文
        // 设置响应行
        setRespRow(resp);
        // 设置响应头
        setRespHeader(resp);
        // 设置响应体
        // 响应字符串数据演示
        resp.getWriter().println("a");
        resp.getWriter().println("<br>");
        resp.getWriter().println('A');
        resp.getWriter().println("<br>");
        resp.getWriter().println(1);
        resp.getWriter().println("<br>");
        resp.getWriter().println(true);

    }

    private void setRespHeader(HttpServletResponse resp) throws IOException {
        // 页面刷新,第一个参数则是等待几秒刷新页面,第二个参数则是具体要刷新的页面
        //resp.setHeader("refresh","6;http://www.baidu.com");
        // 设置请求数据的格式及编码格式-方式一
        resp.setHeader("content-type","text/html;charset=utf-8");
        //  设置编码格式方式二
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("响应结果");
    }

    private void setRespRow(HttpServletResponse resp) {
        // 设置返回状态码
        resp.setStatus(666);
    }
}
