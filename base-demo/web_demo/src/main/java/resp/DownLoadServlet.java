package resp;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件下载演示
 *
 * @Author WangXinWei
 * @Date 2022/2/21 16:17
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取文件名
        String fileName = req.getParameter("fileName");
        // 2. 获取文件格式
        String mimeType = req.getServletContext().getMimeType(fileName);
        // 3. 设置响应头,告诉浏览器以附件的形式打开文件
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);
        // 4. 设置文件类型
        resp.setContentType(mimeType);
        // 5. 文件所在的上级目录路径
        String realPath = req.getServletContext().getRealPath("/resource");
        // 6. 创建文件
        File file = new File(realPath, fileName);
        // 7. 通过输入流读取文件
        FileInputStream inputStream = new FileInputStream(file);
        // 8. 将读取的文件通过响应对象中的输出流输出
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        // 关闭流
        inputStream.close();
    }
}
