package com.spring.springmvc.forwardandredirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * springmvc完成重定向和转发 注解
 *
 * @Author WangXinWei
 * @Date 2022/3/13 22:10
 * @Version 1.0
 */
@Controller
@RequestMapping("/jump")
public class JumpController {
    @GetMapping("/forward")
    public String forwardTest() {
        return "forward:show2?id=1&type=forward";
    }

    @GetMapping("/redirect")
    public String redirectTest() {
        return "redirect:show2?id=2&type=redirect";
    }

    @GetMapping("/show2")
    public void show2(HttpServletResponse response, @RequestParam("id") String id, @RequestParam("type") String type) throws IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().print("跳转成功..." + "id: " + id + "类型: " + type);
    }

}
