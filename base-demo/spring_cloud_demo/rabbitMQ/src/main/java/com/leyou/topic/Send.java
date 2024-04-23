package com.leyou.topic;

import com.leyou.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

/**
 * 生产者
 *
 * @Author WangXinWei
 * @Date 2022/3/23 23:58
 * @Version 1.0
 */
public class Send {
    private final static String EXCHANGE_NAME = "topic_exchange_test";

    public static void main(String[] argv) throws Exception {
        /**
         * 发送者步骤:
         * 1. 获取连接
         * 2. 创建通道
         * 3. 声明队列
         * 4. 往队列中发送消息
         * 5. 关闭连接
         */
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道，使用通道才能完成消息相关的操作
        Channel channel = connection.createChannel();
        // 声明（创建）队列 参数一: 交换机名字  第二: 交换机类型  第三: 交换机是否持久化,默认false,不持久化
        channel.exchangeDeclare(EXCHANGE_NAME,"topic",true);
        // 消息内容
        String message = "Hello World!";
        // 向指定的队列中发送消息
        // 参数1: 交换机名字  参数2: 通配符(路由规则) 参数3: 消息持久化,默认是null  参数4: 消息转为二进制
        channel.basicPublish(EXCHANGE_NAME,"item.insert" , MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
