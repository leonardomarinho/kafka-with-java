package com.marinho.kafkawithjava.consumer;

import com.marinho.kafkawithjava.model.SimpleMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class MyTopicConsumer {

    private final String TOPIC = "myTopic";
    private final String GROUP = "my-group";
    private final String FACTORY = "concurrentKafkaListenerContainerFactory";
    private final List<SimpleMessage> simpleMessages = new ArrayList<>();

    @KafkaListener(topics = TOPIC, groupId = GROUP, containerFactory = FACTORY)
    public void listen(SimpleMessage simpleMessage){
        synchronized (simpleMessages){
            simpleMessages.add(simpleMessage);
        }
    }

    public List<SimpleMessage> getSimpleMessages(){
        return simpleMessages;
    }
}
