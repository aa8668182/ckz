package com.ckz.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;


/**
 * @author: caikaizhen
 * @date: 2019/3/13 13:57
 * @Description:
 */
//开启springsession共享 走gateway???
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=3600)
public class HttpSessionConfig {

    @Bean
    public HttpSessionIdResolver cookiehttpSessionStrategy() {
        return new CookieHttpSessionIdResolver();
    }
   /* @Bean
    public HttpSessionIdResolver headerHttpSessionStrategy() {
        return new HeaderHttpSessionIdResolver("x-auth-token");
    }*/
}
