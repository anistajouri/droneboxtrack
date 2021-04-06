package com.sofrecom.droneboxtracker.bookingms.application.sagas;

import com.sofrecom.droneboxtracker.bookingms.application.commands.DroneBoxBookingService;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.AssignRouteToDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.AssignTrackingDetailsToDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxBookedEvent;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxRoutedEvent;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxTrackedEvent;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

/**
 * The Booking Saga Manager is the implementation of the Booking saga.
 * The Saga starts when the DroneBox Booked Event is raised
 * The Saga ends when the Tracking Details have been assigned to the DroneBox
 */

@Slf4j
@Saga
public class BookingSagaManager {

    @Autowired
    private transient CommandGateway commandGateway;

    @Autowired
    private DroneBoxBookingService droneboxBookingService;

    public BookingSagaManager(){

    }

    @Autowired
    public void setCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    /**
     * Dependencies for the Saga Manager
     * @param commandGateway
     */
    public BookingSagaManager(CommandGateway commandGateway,DroneBoxBookingService droneboxBookingService){
        this.commandGateway = commandGateway;
        this.droneboxBookingService = droneboxBookingService;
    }

    /**
     * Handle the DroneBox Booked Event, Start the Saga and invoke the Assign Route to DroneBox Command
     * @param droneboxBookedEvent
     */
    @StartSaga
    @SagaEventHandler(associationProperty = "bookingId")
    public void on(DroneBoxBookedEvent droneboxBookedEvent){
        log.info("1- Start Saga LifeCycle:::::::::: Handling the DroneBox Booked Event within the Saga BookingId = "+droneboxBookedEvent.getBookingId());

        //Send the Command to assign a route to the DroneBox
        droneboxBookingService.assignRouteToDroneBox(droneboxBookedEvent.getBookingId(),
                                            droneboxBookedEvent.getRouteSpecification());
    }

    /**
     * Handle the DroneBox Routed Event and invoke the Assign Tracking Details to DroneBox Command
     * @param droneboxRoutedEvent
     */
    @SagaEventHandler(associationProperty = "bookingId")
    public void on(DroneBoxRoutedEvent droneboxRoutedEvent){
        log.info("2- Handling the DroneBox Routed Event within the Saga BookingId = "+droneboxRoutedEvent.getBookingId());

        String trackingId = UUID.randomUUID().toString(); // Generate a random tracking identifier

        SagaLifecycle.associateWith("trackingId",trackingId);

        //Send the Command to assign tracking details to the DroneBox
        commandGateway.send(new AssignTrackingDetailsToDroneBoxCommand(
                        droneboxRoutedEvent.getBookingId(),trackingId));
    }

    /**
     * Handle the DroneBox Tracked Event and end the Saga
     * @param droneboxTrackedEvent
     */
    @SagaEventHandler(associationProperty = "trackingId")
    public void on(DroneBoxTrackedEvent droneboxTrackedEvent) {
        log.info("3- End Saga LifeCycle:::::::::: Handling the DroneBox Tracked Event within the Saga trackingId = " + droneboxTrackedEvent.getTrackingId());
        SagaLifecycle.end();
    }

}
