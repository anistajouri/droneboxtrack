package com.sofrecom.droneboxtracker.shareddomain.events;


/**
 * Event Class for the DroneBox Routed Event. Wraps up the DroneBox
 */

public class DroneBoxRoutedEvent {
    private DroneBoxRoutedEventData droneboxRoutedEventData;
    public void setContent(DroneBoxRoutedEventData droneboxRoutedEventData) { this.droneboxRoutedEventData = droneboxRoutedEventData; }
    public DroneBoxRoutedEventData getContent() {
        return droneboxRoutedEventData;
    }
}