package com.tao.spring.util;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author DongTao
 * @since 2019-10-16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test() {
        redisUtils.set("foo", "bar");
        String value = redisUtils.get("foo");
        System.out.println(value);
    }

    @Test
    public void test2() {
        redisTemplate.opsForValue().set("time", "123", 60, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("time"));
        System.out.println(redisTemplate.getExpire("time"));

        redisTemplate.opsForValue().set("time2", "1234");
        System.out.println(redisTemplate.opsForValue().get("time2"));
        System.out.println(redisTemplate.getExpire("time2"));

    }
}