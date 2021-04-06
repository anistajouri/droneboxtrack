package com.sofrecom.droneboxtracker.bookingms.domain.events;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Event resulting from the DroneBox Booking Command
 */
public class DroneBoxTrackedEvent
{
    private String trackingId;

    private String bookingId;



    @JsonCreator
    public DroneBoxTrackedEvent(@JsonProperty("trackingId") String trackingId, String bookingId){
        this.bookingId = bookingId;
        this.trackingId = trackingId;
    }

    public String getBookingId(){ return this.bookingId; }
    public String getTrackingId(){return this.trackingId;}
}
