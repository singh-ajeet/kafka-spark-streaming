package org.ajeet.learnings.spark.streaming.meetup.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public final class TestConsumer {
    private final Logger LOG = LoggerFactory.getLogger(TestConsumer.class);

    @KafkaListener(topics = "spatial", groupId = "spatial_group")
    public void consume(String rsvpEvent) throws IOException {
        LOG.info(rsvpEvent);
    }
}