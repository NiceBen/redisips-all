package com.zsl.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisIpsProperties.class)
public class RedisIpsConfiguration {

    @Bean(name = "jedisIps")
    @ConditionalOnMissingBean(name = "jedisIps")
    public Jedis jedis(RedisIpsProperties redisIpsProperties) {
        System.out.println("Jedis 正在注入 IOC ...");
        return new Jedis(redisIpsProperties.getHost(), redisIpsProperties.getPort());
    }
}
