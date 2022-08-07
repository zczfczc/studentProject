package com.zfc.hello;

import com.rabbitmq.client.*;
import com.zfc.RabbitConnectionUtil;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @auther:zfc
 * @Date:2022-08-06 17:07
 **/
public class Consumer {

    @Test
    public void Consume() throws Exception {
        // 1.创建连接对象
        Connection connection =
                RabbitConnectionUtil.getConnection();
        // 2.创建通道
        Channel channel =
                connection.createChannel();
        // 3.构建队列
        channel.queueDeclare("hello", false, false, false, null);

        // 4.监听信息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者信息：" + new String(body, "UTF-8"));
            }
        };

        channel.basicConsume("hello", true, consumer);
        System.out.println("开始监听队列！");

        System.in.read();
    }

}
