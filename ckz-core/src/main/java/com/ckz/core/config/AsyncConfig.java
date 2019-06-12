package com.ckz.core.config;

import com.alibaba.fastjson.JSON;
import com.ckz.core.exception.AsyncException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.lang.reflect.Method;

/**
 * @author: caikaizhen
 * @date: 2019/3/15 16:48
 * @Description:
 */
@Configuration
@Slf4j
public class AsyncConfig implements AsyncConfigurer {

   /* @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(7);
        executor.setMaxPoolSize(42);
        executor.setQueueCapacity(11);
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }*/

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new GlobalAsyncExceptionHandler();
    }

    /**
     * //TODO 异步异常全局处理
     */
    class GlobalAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... params) {
            log.info("Async method: {} has uncaught exception,params:{}", method.getName(), JSON.toJSONString(params));
            throw new AsyncException(throwable);
        }

    }
}
