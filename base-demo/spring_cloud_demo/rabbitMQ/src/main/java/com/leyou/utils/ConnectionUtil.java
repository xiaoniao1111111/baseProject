package com.leyou.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *   RabbitMQ建立连接
 *
 * @Author WangXinWei * @Date 2022/3/24 0:01
 * @Version 1.0
 */
public class ConnectionUtil {
    /**
     * 建立与RabbitMQ的连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        // 1.获取工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2.设置IP,端口号
        factory.setHost("192.168.56.66");
        factory.setPort(5672);
        // 3.设置虚拟机
        factory.setVirtualHost("/leyou");
        // 4.设置用户名和密码
        factory.setUsername("leyou");
        factory.setPassword("123321");
        // 5.通过工厂获取连接
        return factory.newConnection();
    }
}
