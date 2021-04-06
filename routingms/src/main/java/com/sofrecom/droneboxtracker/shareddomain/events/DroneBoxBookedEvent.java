package com.sofrecom.droneboxtracker.shareddomain.events;


/**
 * Event Class for the DroneBox Booked Event. Wraps up the DroneBox Booking identifier
 * for the event
 */

public class DroneBoxBookedEvent {
    private DroneBoxBookedEventData droneboxBookedEventData;
    private DroneBoxBookedEvent(){}
    public DroneBoxBookedEvent(DroneBoxBookedEventData droneboxBookedEventData){
        this.droneboxBookedEventData  = droneboxBookedEventData;
    }
}
