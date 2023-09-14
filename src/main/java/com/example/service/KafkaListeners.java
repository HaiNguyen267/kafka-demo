package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "hello-world", groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener received: " + data + " 🚀");
    }
}
