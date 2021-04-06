package com.sofrecom.droneboxtracker.handlingms.application.internal.outboundservices;

import com.sofrecom.droneboxtracker.handlingms.infrastructure.brokers.rabbitmq.DroneboxEventSource;
import com.sofrecom.droneboxtracker.shareddomain.events.DroneboxHandledEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 *
 */
@Service
@EnableBinding(DroneboxEventSource.class)
public class DroneBoxEventPublisherService {

    DroneboxEventSource droneboxEventSource;

    public DroneBoxEventPublisherService(DroneboxEventSource droneboxEventSource){
        this.droneboxEventSource = droneboxEventSource;
    }

    @TransactionalEventListener
    public void handleDroneboxHandledEvent(DroneboxHandledEvent droneboxHandledEvent){
        droneboxEventSource.droneboxHandling().send(MessageBuilder.withPayload(droneboxHandledEvent).build());
    }
}
