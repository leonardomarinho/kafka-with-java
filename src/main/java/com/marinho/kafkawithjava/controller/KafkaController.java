package com.marinho.kafkawithjava.controller;

import com.marinho.kafkawithjava.consumer.MyTopicConsumer;
import com.marinho.kafkawithjava.model.SimpleMessage;
import com.marinho.kafkawithjava.producer.MyTopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private MyTopicProducer myTopicProducer;

    @Autowired
    private MyTopicConsumer myTopicConsumer;

    @Value("${kafka.default.topic}")
    private String DEFAULT_TOPIC;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendSimpleMessage(@Valid @RequestBody SimpleMessage simpleMessage) {
        myTopicProducer.send(DEFAULT_TOPIC, simpleMessage);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public List<SimpleMessage> getSimpleMessages(){
        return myTopicConsumer.getSimpleMessages();
    }

}
