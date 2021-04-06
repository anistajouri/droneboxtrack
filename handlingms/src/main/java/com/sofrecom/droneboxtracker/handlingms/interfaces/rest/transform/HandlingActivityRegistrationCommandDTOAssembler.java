package com.sofrecom.droneboxtracker.handlingms.interfaces.rest.transform;

import com.sofrecom.droneboxtracker.handlingms.domain.model.commands.HandlingActivityRegistrationCommand;
import com.sofrecom.droneboxtracker.handlingms.interfaces.rest.dto.HandlingActivityRegistrationResource;
import lombok.extern.slf4j.Slf4j;

/**
 * Assembler class to convert the Book DroneBox Resource Data to the Book DroneBox Model
 */
@Slf4j
public class HandlingActivityRegistrationCommandDTOAssembler {

    /**
     * Static method within the Assembler class
     * @param handlingActivityRegistrationResource
     * @return BookDroneBoxCommand Model
     */
    public static HandlingActivityRegistrationCommand toCommandFromDTO(HandlingActivityRegistrationResource handlingActivityRegistrationResource){
        log.info("----------------------------------------------------------");
        log.info("Booking Id : {}", handlingActivityRegistrationResource.getBookingId());
        log.info("Voyage Number : {}",handlingActivityRegistrationResource.getVoyageNumber());
        log.info("locCode : {}",handlingActivityRegistrationResource.getLocCode());
        log.info("HandlingType : {}",handlingActivityRegistrationResource.getHandlingType());
        log.info("Completion Time : {}",handlingActivityRegistrationResource.getCompletionTime());
        return new HandlingActivityRegistrationCommand(
                handlingActivityRegistrationResource.getBookingId(),
                handlingActivityRegistrationResource.getVoyageNumber(),
                handlingActivityRegistrationResource.getLocCode(),
                handlingActivityRegistrationResource.getHandlingType(),
                java.sql.Date.valueOf(handlingActivityRegistrationResource.getCompletionTime())
        );
    }
}
