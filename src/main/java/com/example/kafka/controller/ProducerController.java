package com.example.kafka.controller;

import com.example.kafka.producer.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class ProducerController {
    private final KafkaMessageProducer p;

    public ProducerController(KafkaMessageProducer p) {
        this.p = p;
    }

    @PostMapping
    public String send(@RequestBody String m) {
        p.send("messages-topic", m);
        return "OK";
    }
}