package com.sofrecom.droneboxtracker.bookingms.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * Event resulting from the DroneBox Booking Command
 */
@Getter
@Setter
public class DroneBoxBookedEvent
{
    private  String bookingId;

    private int bookingamount;
    private String originLocation;
    private String routeSpecification;

    @JsonCreator
    public DroneBoxBookedEvent(@JsonProperty("bookingId") String bookingId,
                            @JsonProperty("bookingAmount") int bookingAmount,
                            @JsonProperty("originLocation") String originLocation,
                            @JsonProperty("routeSpecification") String routeSpecification) {
        this.bookingId = bookingId;
        this.bookingamount = bookingAmount;
        this.originLocation = originLocation;
        this.routeSpecification = routeSpecification;

    }
}
