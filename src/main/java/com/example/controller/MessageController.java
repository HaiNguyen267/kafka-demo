package com.example.controller;


import com.example.dto.request.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @PostMapping()
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("hello-world", request.message());
    }
}
