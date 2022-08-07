package com.zfc;

import com.zfc.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther:zfc
 * @Date:2022-08-07 11:19
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitApllication.class)
public class PubsherTest {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void publish(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,"big.black.dog","message");
        System.out.println("发送成功！");
    }

}
