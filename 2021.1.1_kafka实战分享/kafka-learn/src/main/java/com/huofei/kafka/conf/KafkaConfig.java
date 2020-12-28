package com.huofei.kafka.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;

/**
 * description:
 * date: 2020/12/20 21:43
 * author: huofei
 * version: 1.0
 */
@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return (message, exception, consumer) -> {
            System.out.println("消费异常："+message.getPayload());
            return null;
        };
    }}
