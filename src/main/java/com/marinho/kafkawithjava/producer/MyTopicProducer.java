package com.marinho.kafkawithjava.producer;

import com.marinho.kafkawithjava.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyTopicProducer {

    @Autowired
    public KafkaTemplate<String, SimpleMessage> kafkaTemplate;

    public void send(String topic, SimpleMessage message){
        this.kafkaTemplate.send(topic, message);
    }
}
