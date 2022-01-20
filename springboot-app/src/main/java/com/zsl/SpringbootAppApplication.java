package com.zsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class SpringbootAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootAppApplication.class, args);

        Jedis jedisIps = (Jedis) context.getBean("jedisIps");
        jedisIps.set("hello", "world");
        String value = jedisIps.get("hello");
        System.out.println("jedis获取成功：" + value);
    }

//    @Bean(name = "jedisIps")
//    public Jedis jedis() {
//        return new Jedis();
//    }
}
