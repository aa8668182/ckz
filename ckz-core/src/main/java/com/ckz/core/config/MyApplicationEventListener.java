package com.ckz.core.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * spring boot 启动监听类
 * @author: caikaizhen
 *  * @date: 2019/5/16 11:10
 */
@Component
public class MyApplicationEventListener implements ApplicationListener<ApplicationStartedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        SpringApplication app = event.getSpringApplication();
//        app.setShowBanner(false);// 不显示banner信息
        app.setBanner(null);
        logger.info("==MyApplicationEventListener==");

    }
}