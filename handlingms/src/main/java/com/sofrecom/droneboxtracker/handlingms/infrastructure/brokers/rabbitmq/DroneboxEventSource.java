package com.sofrecom.droneboxtracker.handlingms.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Interface depicting all output channels
 */
public interface DroneboxEventSource {

    @Output("droneboxHandlingChannel")
    MessageChannel droneboxHandling();

}
