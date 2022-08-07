package com.zfc.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zfc.RabbitConnectionUtil;
import org.junit.Test;

/**
 * @auther:zfc
 * @Date:2022-08-06 16:45
 **/
public class Publisher {
    @Test
    public void  publish() throws Exception {
        // 1.创建连接对象
        Connection connection = RabbitConnectionUtil.getConnection();
        // 2.创建通道
        Channel channel = connection.createChannel();
        // 3.构建队列
        channel.basicPublish("","hello",null,"zfc".getBytes());

        System.out.println("发送成功！");

        System.in.read();

    }
}
