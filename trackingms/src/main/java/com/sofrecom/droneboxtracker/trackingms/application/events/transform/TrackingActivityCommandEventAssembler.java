package com.sofrecom.droneboxtracker.trackingms.application.events.transform;

import com.sofrecom.droneboxtracker.shareddomain.events.DroneboxHandledEvent;
import com.sofrecom.droneboxtracker.shareddomain.events.DroneboxHandledEventData;
import com.sofrecom.droneboxtracker.trackingms.domain.model.commands.AddTrackingEventCommand;

/**
 * Assembler class to convert the DroneBox Routed Event to the Assign Tracking Number Command Model
 */
public class TrackingActivityCommandEventAssembler {

    /**
     * Static method within the Assembler class
     * @param droneboxHandledEvent
     * @return AssignTrackingNumberCommand Model
     */
    public static AddTrackingEventCommand toCommandFromEvent(DroneboxHandledEvent droneboxHandledEvent){
        DroneboxHandledEventData eventData = droneboxHandledEvent.getDroneboxHandledEventData();
        return new AddTrackingEventCommand(
                eventData.getBookingId(),
                eventData.getHandlingCompletionTime(),
                eventData.getHandlingType(),
                eventData.getHandlingLocation(),
                eventData.getVoyageNumber());
    }
}
