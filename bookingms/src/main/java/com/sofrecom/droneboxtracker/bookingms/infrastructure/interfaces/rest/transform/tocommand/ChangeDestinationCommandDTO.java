package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.tocommand;


import com.sofrecom.droneboxtracker.bookingms.domain.commands.ChangeDestinationCommand;
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.ChangeDestinationDto;

public class ChangeDestinationCommandDTO {

    public static ChangeDestinationCommand toCommandFromDTO(ChangeDestinationDto changeDestinationDto){
        return new ChangeDestinationCommand(changeDestinationDto.getBookingId(),changeDestinationDto.getNewDestLocation());
    }
}
