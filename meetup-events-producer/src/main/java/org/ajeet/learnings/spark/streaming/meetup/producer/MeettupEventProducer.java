package org.ajeet.learnings.spark.streaming.meetup.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public final class MeettupEventProducer {
    private static final String TOPIC = "spatial";
    private static final Logger LOG = LoggerFactory.getLogger(MeettupEventProducer.class);

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
   //     LOG.info("message produced ->" + message);
        kafkaTemplate.send(TOPIC, message);
    }
}
