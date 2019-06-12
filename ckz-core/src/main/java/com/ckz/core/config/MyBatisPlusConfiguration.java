package com.ckz.core.config;

/**
 * @author: caikaizhen
 * @date: 2019/2/18 15:48
 * @Description:
 */

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: caikaizhen
 * @date: 2019/1/7 10:08
 * @Description:
 */
@Configuration
@MapperScan("com.ckz.core.mapper")
public class MyBatisPlusConfiguration {

    /**
     * 逻辑删除 @TableLogic
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * @Version
     * 支持的数据类型只有:int,Integer,long,Long,Date,Timestamp,LocalDateTime
     * 乐观锁
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }



    /**
     * SQL执行效率插件
     */
    @Bean
    @ConditionalOnProperty(value = "istest") //istest
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // maxTime 指的是 sql 最大执行时长
        performanceInterceptor.setMaxTime(3000);

        // SQL是否格式化 默认false
        performanceInterceptor.setFormat(false);
        return performanceInterceptor;
    }



    /**
     * mybatis分页插件
     */
    /*@Bean
    public PageInterceptor serviceInterceptor() {
        return new PageInterceptor();
    }*/


    /*@Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
         // 打开PageHelper localPage 模式
        page.setLocalPage(true);
        return page;
    }*/


}