package com.sofrecom.droneboxtracker.bookingms.application.events;

import com.sofrecom.droneboxtracker.bookingms.application.queries.DroneBoxProjectionService;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxBookedEvent;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxRoutedEvent;
import com.sofrecom.droneboxtracker.bookingms.domain.events.DroneBoxTrackedEvent;
import com.sofrecom.droneboxtracker.bookingms.domain.projections.DroneboxView;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

/**
 * Event Handlers for all events raised by the DroneBox Aggregate
 */
@Slf4j
@Service
public class DroneBoxProjectionsEventHandler {
    private DroneBoxProjectionService droneboxProjectionService; //Dependencies

    public DroneBoxProjectionsEventHandler(DroneBoxProjectionService droneboxProjectionService) {
        this.droneboxProjectionService = droneboxProjectionService;
    }

    /**
     * EVent Handler for the DroneBox Booked Event. Converts the Event Data to the corresponding Aggregate Projection Model
     * and delegates to the Application Service to process it further
     *
     * @param droneboxBookedEvent
     */
    @EventHandler
    public void droneboxBookedEventHandler(DroneBoxBookedEvent droneboxBookedEvent) {
        DroneboxView droneboxView = new DroneboxView(droneboxBookedEvent.getBookingId() + "_BOOKED", "NOT_STARTED", "NOT_ROUTED",
                droneboxBookedEvent.getOriginLocation(), droneboxBookedEvent.getRouteSpecification());
        log.info("BOOKED event Handler : Storing the DroneBoxView BookingID = {}", droneboxBookedEvent.getBookingId());
        droneboxProjectionService.storeDroneboxView(droneboxView);
    }

    /**
     * Event Handler for the DroneBox Routed Event
     *
     * @param droneboxRoutedEvent
     */
    @EventHandler
    public void droneboxRoutedEventhandler(DroneBoxRoutedEvent droneboxRoutedEvent) {
        String itinary = droneboxRoutedEvent.getItinerary();
        if (itinary.length() > 250)
            itinary = itinary.substring(0, 250);

        DroneboxView droneboxView = new DroneboxView(droneboxRoutedEvent.getBookingId(), "NOT_STARTED", "ROUTED",
                "", itinary);
        log.info("ROOTED Handler : Storing the DroneBoxView BookingID = {}", droneboxRoutedEvent.getBookingId());
        droneboxProjectionService.storeDroneboxView(droneboxView);
    }


    @EventHandler
    public void droneboxTrackedEventhandler(DroneBoxTrackedEvent droneBoxTrackedEvent) {
        log.info("TRACKED Handler : Storing the DroneBoxView TrackingID = {}", droneBoxTrackedEvent.getTrackingId());
    }
}