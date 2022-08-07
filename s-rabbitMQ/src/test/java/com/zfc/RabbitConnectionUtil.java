package com.zfc;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * @auther:zfc
 * @Date:2022-08-06 16:52
 **/
public class RabbitConnectionUtil {
    public static Connection getConnection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.56.8");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        return factory.newConnection();
    }


}
