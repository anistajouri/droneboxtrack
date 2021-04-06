package com.sofrecom.droneboxtracker.bookingms.domain.events;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DroneBoxRoutedTrackEvent {
    private DroneBoxRoutedEventData droneboxRoutedEventData;

    public void setContent(DroneBoxRoutedEventData droneboxRoutedEventData) { this.droneboxRoutedEventData = droneboxRoutedEventData; }
    public DroneBoxRoutedEventData getContent() {
        return droneboxRoutedEventData;
    }
}
