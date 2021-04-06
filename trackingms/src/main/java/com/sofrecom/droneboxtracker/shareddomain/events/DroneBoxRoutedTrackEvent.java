package com.sofrecom.droneboxtracker.shareddomain.events;


/**
 * Event Class for the DroneBox Routed Event. Wraps up the DroneBox
 */

public class DroneBoxRoutedTrackEvent {
    private DroneBoxRoutedEventData droneboxRoutedEventData;
    public DroneBoxRoutedTrackEvent(){}
    public DroneBoxRoutedTrackEvent(DroneBoxRoutedEventData droneboxRoutedEventData){
        this.droneboxRoutedEventData = droneboxRoutedEventData;
    }
    public DroneBoxRoutedEventData getDroneBoxRoutedEventData() {
        return droneboxRoutedEventData;
    }
}