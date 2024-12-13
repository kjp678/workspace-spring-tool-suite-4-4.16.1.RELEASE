package com.test.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ThreadPoolInfo {
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @PostConstruct
    public void printThreadPoolInfo() {
        int corePoolSize = taskExecutor.getCorePoolSize();
        int maxPoolSize = taskExecutor.getMaxPoolSize();
        int activeCount = taskExecutor.getActiveCount();
        System.out.println("Core Pool Size: " + corePoolSize);
        System.out.println("Max Pool Size: " + maxPoolSize);
        System.out.println("Active Count: " + activeCount);
    }
}