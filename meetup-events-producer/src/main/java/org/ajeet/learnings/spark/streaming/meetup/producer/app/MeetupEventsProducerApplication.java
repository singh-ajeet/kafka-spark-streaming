package org.ajeet.learnings.spark.streaming.meetup.producer.app;

import org.ajeet.learnings.spark.streaming.meetup.producer.MeetupEventsWebSocketHandler;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.annotation.PreDestroy;

@SpringBootApplication
@ComponentScan("org.ajeet.learnings.spark.streaming")
public class MeetupEventsProducerApplication {
	private static final String MEETUP_ENDPOINT = "ws://stream.meetup.com/2/rsvps";

	public static void main(String[] args) {
		SpringApplication.run(MeetupEventsProducerApplication.class, args);
	}

	@Bean
	public ApplicationRunner startProducingEvents(MeetupEventsWebSocketHandler rsvpsWebSocketHandler) {
		return args -> {
			WebSocketClient rsvpsSocketClient = new StandardWebSocketClient();
			rsvpsSocketClient.doHandshake(rsvpsWebSocketHandler, MEETUP_ENDPOINT);
		};
	}


	@PreDestroy
	public void shutdownApplication(){
		System.out.println("=============================================================");
		System.out.println("================== Shutting down application ================");
		System.out.println("=============================================================");
	}
}