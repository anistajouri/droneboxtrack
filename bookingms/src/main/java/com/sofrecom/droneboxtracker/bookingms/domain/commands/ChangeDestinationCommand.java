package com.sofrecom.droneboxtracker.bookingms.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@AllArgsConstructor
public class ChangeDestinationCommand {
    @TargetAggregateIdentifier
    //Identifier to indicate to Axon framework the unique instance on which the Command needs to be processed
    private String bookingId;

    private String newDestinationLocation;
}
