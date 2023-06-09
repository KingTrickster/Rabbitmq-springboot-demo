package com.trxjster.rabbitmqspringbootdemo.consumer;

import com.trxjster.rabbitmqspringbootdemo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user){
        LOGGER.info(String.format("Received JSON message -> %s", user.toString()));
    }
}
