package com.trxjster.rabbitmqspringbootdemo.controller;

import com.trxjster.rabbitmqspringbootdemo.dto.User;
import com.trxjster.rabbitmqspringbootdemo.publisher.RabbitmqJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private final RabbitmqJsonProducer rabbitmqJsonProducer;

    public MessageJsonController(RabbitmqJsonProducer rabbitmqJsonProducer) {
        this.rabbitmqJsonProducer = rabbitmqJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitmqJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to Rabbitmq...");
    }
}
