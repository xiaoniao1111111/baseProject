package com.leyou.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 短信监听器
 *
 * @Author WangXinWei
 * @Date 2022/3/30 16:19
 * @Version 1.0
 */
@Component
public class MQListener {
    @RabbitListener(bindings = @QueueBinding(
            // 参数一: 队列名字  参数二: 持久化
            value = @Queue(value = "spring.test.queue", durable = "true"),
            // 交换机与队列进行绑定
            exchange = @Exchange(
                    value = "spring.test.exchange",
                    ignoreDeclarationExceptions = "true",
                    // 订阅消息模型中的通配符类型
                    type = ExchangeTypes.TOPIC
            ),
            key = {"#.#"}))
    public void listen(String msg) {
        System.out.println("接收到消息：" + msg);
    }
}
