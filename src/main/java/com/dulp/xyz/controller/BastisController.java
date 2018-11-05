package com.dulp.xyz.controller;

import com.dulp.xyz.common.redis.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BastisController {
    @Autowired
    public RedisOperator redisOperator;
    public static final String USER_REDIS_SESSION = "user-redis-session";
}
