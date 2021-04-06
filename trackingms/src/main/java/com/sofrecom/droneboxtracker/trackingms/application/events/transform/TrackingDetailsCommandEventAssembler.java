package com.sofrecom.droneboxtracker.trackingms.application.events.transform;

import com.sofrecom.droneboxtracker.shareddomain.events.DroneBoxRoutedTrackEvent;
import com.sofrecom.droneboxtracker.trackingms.domain.model.commands.AssignTrackingNumberCommand;

/**
 * Assembler class to convert the DroneBox Routed Event to the Assign Tracking Number Command Model
 */
public class TrackingDetailsCommandEventAssembler {

    /**
     * Static method within the Assembler class
     * @param droneboxRoutedEvent
     * @return AssignTrackingNumberCommand Model
     */
    public static AssignTrackingNumberCommand toCommandFromEvent(DroneBoxRoutedTrackEvent droneboxRoutedEvent){
        return new AssignTrackingNumberCommand(
                                   droneboxRoutedEvent.getDroneBoxRoutedEventData().getBookingId(),"");
    }
}
