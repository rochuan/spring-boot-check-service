package com.mdx.spider.provider.config;


import org.springframework.stereotype.Component;

@Component
public class UserSession {

    private ThreadLocal<Long> tc = new ThreadLocal<Long>();

    public Long getUserId() {
        return tc.get();
    }

    public void setUserId(Long userId) {
        tc.set(userId);
    }


}
