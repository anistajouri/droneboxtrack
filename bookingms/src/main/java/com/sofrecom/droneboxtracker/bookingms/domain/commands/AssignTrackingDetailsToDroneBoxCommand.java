package com.sofrecom.droneboxtracker.bookingms.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Implementation class for the Assign Tracking Details to DroneBox Command
 */
public class AssignTrackingDetailsToDroneBoxCommand {
    private String bookingId;
    @TargetAggregateIdentifier
    //Identifier to indicate to Axon framework the unique instance on which the Command needs to be processed
    private String trackingId;
    public AssignTrackingDetailsToDroneBoxCommand(String bookingId, String trackingId){
        this.bookingId = bookingId;
        this.trackingId = trackingId;
    }

    public void setBookingId(String bookingId){this.bookingId = bookingId;}
    public String getBookingId(){return this.bookingId;}
    public void setTrackingId(String trackingId){this.trackingId = trackingId;}
    public String getTrackingId(){return this.trackingId;}
}
