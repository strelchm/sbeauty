package com.bank.transactions.data.config;

import com.bank.transactions.data.config.props.ThreadPoolConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ForkJoinPool;

@Configuration
public class ThreadPoolConfig {

    @Bean
    public ForkJoinPool transactionProcessingThreadPool(ThreadPoolConfigProperties props) {
        return new ForkJoinPool(props.getParallelism());
    }
}
