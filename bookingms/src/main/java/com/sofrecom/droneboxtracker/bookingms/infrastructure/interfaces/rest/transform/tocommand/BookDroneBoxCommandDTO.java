package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.tocommand;

import com.sofrecom.droneboxtracker.bookingms.domain.commands.BookDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.BookDroneBoxDto;

/**
 * Assembler class to convert the Book DroneBox Dto Data to the Book DroneBox Model
 */
public class BookDroneBoxCommandDTO {

    /**
     * Static method within the Assembler class
     * @param bookDroneBoxDto
     * @return BookDroneBoxCommand Model
     */
    public static BookDroneBoxCommand toCommandFromDTO(BookDroneBoxDto bookDroneBoxDto){

        return new BookDroneBoxCommand(bookDroneBoxDto.getBookingId(),
                                    bookDroneBoxDto.getBookingAmount(),
                                    bookDroneBoxDto.getOriginLocation(),
                                    bookDroneBoxDto.getDestLocation()/*,
                                    bookDroneBoxDto.getDestArrivalDeadline()*/);
    }
}
