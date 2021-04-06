package com.sofrecom.droneboxtracker.trackingms.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface HandlingBinding {

    String HANDLING = "droneboxHandlingChannel";

    @Input(HANDLING)
    SubscribableChannel droneboxHandling();
}
