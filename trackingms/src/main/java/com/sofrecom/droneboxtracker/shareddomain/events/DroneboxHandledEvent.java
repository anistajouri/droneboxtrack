package com.sofrecom.droneboxtracker.shareddomain.events;

public class DroneboxHandledEvent {
    private DroneboxHandledEventData droneboxHandledEventData;
    public DroneboxHandledEvent(){}
    public DroneboxHandledEvent(DroneboxHandledEventData droneboxHandledEventData){
        this.droneboxHandledEventData = droneboxHandledEventData;
    }
    public DroneboxHandledEventData getDroneboxHandledEventData() {
        return this.droneboxHandledEventData;
    }
}
