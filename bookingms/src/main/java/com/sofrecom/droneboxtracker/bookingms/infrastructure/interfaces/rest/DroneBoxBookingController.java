package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest;


import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.tocommand.BookDroneBoxCommandDTO;
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.BookDroneBoxDto;
import com.sofrecom.droneboxtracker.bookingms.application.commands.DroneBoxBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * REST API for the Book DroneBox Command
 */
@RestController
@RequestMapping("/droneboxbooking")
public class DroneBoxBookingController {


    private final DroneBoxBookingService droneboxBookingService; // Application Service Dependency

    /**
     * Provide the dependencies
     * @param droneboxBookingService
     */
    public DroneBoxBookingController(DroneBoxBookingService droneboxBookingService){
        this.droneboxBookingService = droneboxBookingService;
    }

    /**
     * POST method to book a dronebox
     * @param bookDroneBoxCommandDto
     */
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String bookDroneBox(@RequestBody final BookDroneBoxDto bookDroneBoxCommandDto){
        String random = UUID.randomUUID().toString().toUpperCase();
        String bookId = random.substring(0, random.indexOf("-"));
        bookDroneBoxCommandDto.setBookingId(bookId);
        return droneboxBookingService.bookDroneBox(BookDroneBoxCommandDTO.toCommandFromDTO(bookDroneBoxCommandDto));
//      return bookId;
    }
}