package com.sofrecom.droneboxtracker.bookingms.domain.queries;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implementation of DroneBox View Query class. It takes in a Booking Id which is the criteria for the query
 */
public class DroneboxViewQuery {

    private String bookingId; //Criteria of the Query

    @JsonCreator
    public DroneboxViewQuery(@JsonProperty("bookingId") String bookingId){
        this.bookingId = bookingId;
    }

    public String getBookingId(){return this.bookingId;}
    @Override
    public String toString() { return "DroneBox View for Booking Id" + bookingId; }
}
