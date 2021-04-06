package com.sofrecom.droneboxtracker.trackingms.application.events;


import com.sofrecom.droneboxtracker.shareddomain.events.DroneboxHandledEvent;
import com.sofrecom.droneboxtracker.trackingms.application.commandservices.AssignTrackingIdCommandService;
import com.sofrecom.droneboxtracker.trackingms.infrastructure.brokers.rabbitmq.HandlingBinding;
import com.sofrecom.droneboxtracker.trackingms.application.events.transform.TrackingActivityCommandEventAssembler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * Event Handler for the DroneBox Routed Event that the Tracking Bounded Context is interested in
 */
@Service
@EnableBinding(HandlingBinding.class)
public class DroneboxHandledEventHandler {

    private AssignTrackingIdCommandService assignTrackingIdCommandService; // Application Service Dependency

    /**
     * Provide the dependencies
     * @param assignTrackingIdCommandService
     */
    public DroneboxHandledEventHandler(AssignTrackingIdCommandService assignTrackingIdCommandService) {
        this.assignTrackingIdCommandService = assignTrackingIdCommandService;
    }

    @StreamListener(target = HandlingBinding.HANDLING)
    public void receiveEvent(DroneboxHandledEvent droneboxHandledEvent) {
        //Process the Event
        System.out.println("Received Handled: "+droneboxHandledEvent.getDroneboxHandledEventData());
        assignTrackingIdCommandService.addTrackingEvent(
                TrackingActivityCommandEventAssembler
                        .toCommandFromEvent(droneboxHandledEvent));

    }
}
