package com.leyou.fanout;

import com.leyou.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 消费者2
 *
 * @Author WangXinWei
 * @Date 2022/3/24 0:00
 * @Version 1.0
 */
public class Consumer2 {
    private final static String QUEUE_NAME = "fanout_exchange_queue_2";
    private final static String EXCHANGE_NAME = "fanout_exchange_test";
    public static void main(String[] argv) throws Exception {
        /**
         * 消费者步骤:
         * 1. 获取连接
         * 2. 创建通道
         * 3. 声明队列
         * 4. 定义消费者,从队列中获取消息
         * 5. 设置消息的ACK机制
         */
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        // 设置每个消费者同时只能消费1条消息
        channel.basicQos(1);
        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                // body 即消息体
                String msg = new String(body);
                System.out.println(" [消费者2] received : " + msg + "!");
                // 手动ACK
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 监听队列，第二个参数：是否自动进行消息确认。
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
