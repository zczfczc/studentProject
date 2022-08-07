package com.zfc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther:zfc
 * @Date:2022-08-06 13:25
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestRedis {

    @Autowired
    public RedisTemplate redisTemplate;
    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisss(){
//        redisTemplate.opsForValue().set("dd","dd");
        stringRedisTemplate.opsForValue().set("zz","zz");
    }

}
