package com.bank.transactions.data.config.props;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
@ConfigurationProperties(prefix = "thread-pool.transaction-processing")
public class ThreadPoolConfigProperties {

    @NotNull
    private Integer parallelism;

    public Integer getParallelism() {
        return parallelism;
    }

    public void setParallelism(@NotNull Integer parallelism) {
        this.parallelism = parallelism;
    }
}
