package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;


import com.sofrecom.droneboxtracker.bookingms.domain.commands.AssignTrackingDetailsToDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.BookDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxBookedEvent;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxDestinationChangedEvent;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxTrackedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class TrackingDroneBox {

    private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AggregateIdentifier
    private String trackingId; // Aggregate Identifier

    private String bookingId;


    public TrackingDroneBox() {
        // Required by Axon Framework
    }

    @CommandHandler
    public TrackingDroneBox(AssignTrackingDetailsToDroneBoxCommand assignTrackingDetailsToDroneBoxCommand) {
        logger.info("Tracking DroneBox Command.....booking {} --> tracking {}..........", assignTrackingDetailsToDroneBoxCommand.getBookingId(),
                assignTrackingDetailsToDroneBoxCommand.getTrackingId());
        apply( new DroneBoxTrackedEvent(assignTrackingDetailsToDroneBoxCommand.getTrackingId(),
                assignTrackingDetailsToDroneBoxCommand.getBookingId()));

    }

    @EventSourcingHandler
    //Annotation indicating that the Aggregate is Event Sourced and is interested in the DroneBox tracked Event raised by the assignTrackingDetailsToDroneBoxCommand
    public void on(DroneBoxTrackedEvent droneboxTrackedEvent) {
        logger.info("Applying {}", droneboxTrackedEvent);
        trackingId = droneboxTrackedEvent.getTrackingId();
    }
}