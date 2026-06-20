package com.vasanth.projects.flashsale.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

@Configuration
public class RedisConfig {

    @Bean
    public RedisScript<Long> stockScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        // This tells Spring to find the file you just made in the resources folder
        redisScript.setLocation(new ClassPathResource("stock_decrement.lua"));
        // We explicitly tell Spring to expect a Long back (1 for success, 0 for failure)
        redisScript.setResultType(Long.class);
        return redisScript;
    }
}