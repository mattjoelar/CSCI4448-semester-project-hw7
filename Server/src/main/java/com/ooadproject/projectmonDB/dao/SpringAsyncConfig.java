package com.ooadproject.projectmonDB.dao;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAutoConfiguration
@EnableAsync
@ComponentScan
public class SpringAsyncConfig implements AsyncConfigurer {
    /*@Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }*/
    @Bean(name = "threadPoolTaskExecutor")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setMaxPoolSize(2);
        threadPoolTaskExecutor.setQueueCapacity(500);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
