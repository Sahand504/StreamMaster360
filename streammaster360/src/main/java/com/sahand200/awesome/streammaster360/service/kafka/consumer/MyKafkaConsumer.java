package com.sahand200.awesome.streammaster360.service.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(MyKafkaConsumer.class);

    @KafkaListener(topics = "users", groupId = "processing_group")
    public void consume(String message) {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
