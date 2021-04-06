package com.sofrecom.droneboxtracker.bookingms.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.Date;

/**
 * Implementation Class for the Booking DroneBox Command
 */
@Getter
@Setter
@AllArgsConstructor
public class BookDroneBoxCommand {
    @TargetAggregateIdentifier //Identifier to indicate to Axon framework the unique instance on which the Command needs to be processed
    private String bookingId;

    private int bookingAmount;
    private String originLocation;
    private String destLocation;
    //private Date destArrivalDeadline;
}
