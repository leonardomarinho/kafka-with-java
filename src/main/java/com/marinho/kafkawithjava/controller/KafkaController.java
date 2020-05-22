package com.marinho.kafkawithjava.controller;

import com.marinho.kafkawithjava.consumer.MyTopicConsumer;
import com.marinho.kafkawithjava.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, SimpleMessage> kafkaTemplate;

    @Autowired
    private MyTopicConsumer myTopicConsumer;

    @Value("${kafka.default.topic}")
    private String DEFAULT_TOPIC;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleMessage> sendSimpleMessage(@Valid @RequestBody SimpleMessage simpleMessage) {
        kafkaTemplate.send(DEFAULT_TOPIC, simpleMessage);
        return ResponseEntity.ok(simpleMessage);
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public List<SimpleMessage> getSimpleMessages(){
        return myTopicConsumer.getSimpleMessages();
    }
}
