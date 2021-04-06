package com.sofrecom.droneboxtracker.bookingms.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Event that gets generated when the DroneBox is Routed
 */
@Getter
@Setter
public class DroneBoxRoutedEvent implements Serializable {
    private String bookingId;
    private String itinerary;

    @JsonCreator
    public DroneBoxRoutedEvent(@JsonProperty("bookingId") String bookingId, String itinerary ){
        this.bookingId = bookingId;
        this.itinerary = itinerary;
    }
}
