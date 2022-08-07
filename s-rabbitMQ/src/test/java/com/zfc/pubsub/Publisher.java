package com.zfc.pubsub;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zfc.RabbitConnectionUtil;
import org.junit.Test;

/**
 * @auther:zfc
 * @Date:2022-08-06 16:45
 **/
public class Publisher {

    public static final String EXCHANGE_NAME = "pubsub";

    public static final String QUEUE_NAME1 = "p-one";
    public static final String QUEUE_NAME2 = "p-two";

    @Test
    public void publish() throws Exception {
        // 1.创建连接对象
        Connection connection = RabbitConnectionUtil.getConnection();
        // 2.创建通道
        Channel channel = connection.createChannel();
        // 3.构建交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        // 4.构建队列
        channel.queueDeclare(QUEUE_NAME1, false, false, false, null);
        channel.queueDeclare(QUEUE_NAME2, false, false, false, null);

        // 5.绑定交换机
        channel.queueBind(QUEUE_NAME1,EXCHANGE_NAME,"");
        channel.queueBind(QUEUE_NAME2,EXCHANGE_NAME,"");

        channel.basicPublish(EXCHANGE_NAME,"",null,"pubsub".getBytes());

        System.out.println("发送成功！");


    }
}
