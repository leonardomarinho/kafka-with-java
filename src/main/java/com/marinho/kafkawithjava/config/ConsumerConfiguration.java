package com.marinho.kafkawithjava.config;


import com.marinho.kafkawithjava.model.SimpleMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class ConsumerConfiguration {

    @Value("${kafka.default.broker}")
    private String DEFAULT_BROKER;

    @Value("${kafka.default.group}")
    private String DEFAULT_GROUP;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SimpleMessage> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(consumerFactory());

        return listenerContainerFactory;
    }

    @Bean
    public ConsumerFactory<String, SimpleMessage> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfigurations(),
                new StringDeserializer(),
                new JsonDeserializer<>(SimpleMessage.class));
    }

    @Bean
    public Map<String, Object> consumerConfigurations(){
        Map<String, Object> configurations = new HashMap<>();
        configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, DEFAULT_BROKER);
        configurations.put(ConsumerConfig.GROUP_ID_CONFIG, DEFAULT_GROUP);

        return configurations;
    }
}
