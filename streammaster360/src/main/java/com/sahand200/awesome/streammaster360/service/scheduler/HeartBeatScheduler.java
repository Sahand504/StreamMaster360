package com.sahand200.awesome.streammaster360.service.scheduler;

import com.sahand200.awesome.streammaster360.service.kafka.producer.MyKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HeartBeatScheduler {
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatScheduler.class);

    @Autowired
    MyKafkaProducer myKafkaProducer;

    @Scheduled(fixedRate = 5000)
    public void sendHeartbeat() {
        String key = "heartbeat";
        String message = "Heartbeat message at " + System.currentTimeMillis();
        logger.info(String.format("#### -> Generating heartbeat message -> %s", message));
        myKafkaProducer.sendMessage(message);
    }
}
