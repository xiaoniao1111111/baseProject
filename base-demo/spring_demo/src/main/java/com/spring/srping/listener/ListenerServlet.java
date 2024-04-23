package com.spring.srping.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author WangXinWei
 * @Date 2022/3/5 20:54
 * @Version 1.0
 */
@WebServlet("/listenerServlet")
public class ListenerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().print("hello listener....");
        System.out.println("....");
        //spring 监听器
        //每次获取的都是一个spring容器
        // 方式一: 通过属性的方式获取ApplicationContext
        ApplicationContext applicationContext;
       // applicationContext = getPropertiesSpring();
        // 方式二: 通过工具类获取ApplicationContext
        applicationContext=getUtilSpring();
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
        helloService.save();
        System.out.println(applicationContext.hashCode());
    }

    private ApplicationContext getUtilSpring() {
        return (ApplicationContext) WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    }

    private ApplicationContext getPropertiesSpring() {
     return (ApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }
}
