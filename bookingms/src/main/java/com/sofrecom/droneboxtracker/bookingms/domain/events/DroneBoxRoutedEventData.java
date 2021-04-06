package com.sofrecom.droneboxtracker.bookingms.domain.events;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DroneBoxRoutedEventData {
    private String bookingId;
}
