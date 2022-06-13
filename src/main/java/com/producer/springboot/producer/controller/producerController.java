package com.producer.springboot.producer.controller;

import com.producer.springboot.producer.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class producerController {

    @Autowired
    KafkaTemplate<String, Book>kafkaTemplate;

    private static final String TOPIC = "MyTopic";



    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book){

            kafkaTemplate.send(TOPIC, book);
            return "Published successfully";

        }
}

