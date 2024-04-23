package com.spring.springmvc.json;

import com.spring.springmvc.data.Fuit;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author WangXinWei
 * @Date 2022/3/13 10:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/json")
public class JsonController {
    /**
     * 将集合以json方式返回给客户端
     * <p>
     * 当我们不加@ResponseBody或者@RestController注解时会报404错误,因为前端不知道怎么接受这个集合
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/getList")
    public List<Fuit> jsonShoew1(HttpServletRequest request, HttpServletResponse response) {
        Fuit fuit = new Fuit("橘子", 1.1d);
        Fuit fuit1 = new Fuit("苹果", 1.2d);
        Fuit fuit2 = new Fuit("西瓜", 1.3d);
        return Arrays.asList(fuit, fuit1, fuit2);
    }

    /**
     * 字符串类型接受json数据
     *
     * @param response
     * @param name
     * @throws IOException
     */
    @RequestMapping(value = "/jsonShow2")
    public void jsonShow2(HttpServletResponse response, @RequestParam(value = "name") String name) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("接受到的参数为: "+name);
        System.out.println("name = " + name);
    }

    /**
     * pojo接受json数据
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/jsonShow3")
    public void jsonShow3(HttpServletResponse response,@RequestBody Fuit fuit) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("接受到的参数为: " + fuit.toString());
    }

}
