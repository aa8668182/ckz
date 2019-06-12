package com.ckz.core.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author: caikaizhen
 * @date: 2019/3/12 16:26
 * @Description:
 */
@Configuration
public class ThreadPoolConfig {

    /* 线程数量 */
    private static final Integer CUP_POOL_SIZE = (int)(Runtime.getRuntime().availableProcessors()+1);

    /* 线程数量 */
    private static final Integer IO_POOL_SIZE = (int)(Runtime.getRuntime().availableProcessors()*2);


    /**
     * CPU密集型
     * @return
     */
    @Bean(value = "CPUThreadPool")
    public ExecutorService buildCPUThreadPool(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("CPU-thread-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(CUP_POOL_SIZE, 10, 300L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(1024),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        return pool ;
    }



    /**
     * IO密集型
     * @return
     */
    @Bean(value = "IOThreadPool")
    public ExecutorService buildIOThreadPool(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("IO-thread-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(IO_POOL_SIZE, 30, 60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(1024),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        return pool ;
    }


    /**
     * 优先级密集型
     * @return
     */
    @Bean(value = "PriorityThreadPool")
    public ExecutorService buildPriorityThreadPool(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Priority-thread-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(CUP_POOL_SIZE, 10, 60L, TimeUnit.SECONDS,
                new PriorityBlockingQueue<Runnable>(1024),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        return pool ;
    }


}