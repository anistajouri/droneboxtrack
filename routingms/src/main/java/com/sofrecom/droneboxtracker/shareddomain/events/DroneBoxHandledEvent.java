package com.sofrecom.droneboxtracker.shareddomain.events;


public class DroneBoxHandledEvent {

    private DroneBoxHandledEventData droneboxHandledEventData;
    public void setContent(DroneBoxHandledEventData droneboxHandledEventData) { this.droneboxHandledEventData = droneboxHandledEventData; }
    public DroneBoxHandledEventData getContent() {
        return droneboxHandledEventData;
    }
}
