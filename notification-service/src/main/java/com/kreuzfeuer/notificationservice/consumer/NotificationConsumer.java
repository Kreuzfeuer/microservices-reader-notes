package com.kreuzfeuer.notificationservice.consumer;

import com.kreuzfeuer.notificationservice.event.AddPlannedBookEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationConsumer {
    @KafkaListener(topics = "plannedBookTopic", containerFactory = "listenerContainerFactory")
    public void handleAddPlannedBookNotification(AddPlannedBookEvent addPlannedBookEvent) {
        log.info("Got message <{}> ", addPlannedBookEvent);
        //some email sender logic
    }
}
