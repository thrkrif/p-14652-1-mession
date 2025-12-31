package com.back.infra.kafka;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Component
public class MyEventListener {
    private final CountDownLatch latch = new CountDownLatch(1);
    private MyEvent receivedEvent;

    // Consumer
    @KafkaListener(topics = "MyEvent")
    public void handle(MyEvent event) {
        System.out.println("handle MyEvent: " + event.msg());
        this.receivedEvent = event;
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public MyEvent getReceivedEvent() {
        return receivedEvent;
    }
}
