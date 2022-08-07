package com.zfc.work;

import com.rabbitmq.client.*;
import com.zfc.RabbitConnectionUtil;
import org.junit.Test;

import java.io.IOException;

import static com.zfc.work.PublisherWork.QUEUE_NAME;

/**
 * @auther:zfc
 * @Date:2022-08-06 17:07
 **/
public class ConsumerWork {

    @Test
    public void Consume1() throws Exception {
        // 1.创建连接对象
        Connection connection =
                RabbitConnectionUtil.getConnection();
        // 2.创建通道
        Channel channel =
                connection.createChannel();
        // 3.构建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicQos(3);

        // 4.监听信息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者1信息：" + new String(body, "UTF-8"));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };

        channel.basicConsume(QUEUE_NAME, false, consumer);
        System.out.println("开始监听队列！");

        System.in.read();
    }

    @Test
    public void Consume2() throws Exception {
        // 1.创建连接对象
        Connection connection =
                RabbitConnectionUtil.getConnection();
        // 2.创建通道
        Channel channel =
                connection.createChannel();
        // 3.构建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicQos(3);
        // 4.监听信息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者2信息：" + new String(body, "UTF-8"));
                channel.basicAck(envelope.getDeliveryTag(),false);

            }
        };

        channel.basicConsume(QUEUE_NAME, false, consumer);
        System.out.println("开始监听队列！");

        System.in.read();
    }

}
