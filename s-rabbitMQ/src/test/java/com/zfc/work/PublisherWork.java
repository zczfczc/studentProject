package com.zfc.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zfc.RabbitConnectionUtil;
import org.junit.Test;

/**
 * @auther:zfc
 * @Date:2022-08-06 16:45
 **/
public class PublisherWork {

    public static final String QUEUE_NAME = "work";

    @Test
    public void  publish() throws Exception {
        // 1.创建连接对象
        Connection connection = RabbitConnectionUtil.getConnection();
        // 2.创建通道
        Channel channel = connection.createChannel();
        // 3.构建队列
        for (int i = 0; i < 10; i++) {
            String msg = "zfc" + i;
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        }

        channel.basicPublish("",QUEUE_NAME,null,"zfc".getBytes());

        System.out.println("发送成功！");

        System.in.read();

    }
}
