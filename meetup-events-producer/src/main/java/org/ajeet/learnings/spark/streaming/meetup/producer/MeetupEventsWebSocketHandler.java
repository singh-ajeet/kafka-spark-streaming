package org.ajeet.learnings.spark.streaming.meetup.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class MeetupEventsWebSocketHandler extends AbstractWebSocketHandler {
    private static final Logger LOG =LoggerFactory.getLogger(MeetupEventsWebSocketHandler.class);

    @Autowired
    MeettupEventProducer meettupEventProducer;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      //  LOG.info("Producing message ->" + message.getPayload());
        meettupEventProducer.sendMessage(message.getPayload());
    }
}
