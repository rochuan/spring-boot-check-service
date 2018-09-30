package com.mdx.spider.provider.authorization.manager;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class AccessTokenManager {

    public String getAccessToken(String accessToken) {

        if (null == accessToken) {
            return null;
        }
        Jedis jedis = new Jedis("localhost",6379);
        jedis.select(2);
        return  jedis.get(accessToken);

    }
}
