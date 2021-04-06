package com.sofrecom.droneboxtracker.bookingms.application.commands;

import com.sofrecom.droneboxtracker.bookingms.application.acl.ExternalDroneBoxRoutingService;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.AssignRouteToDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.BookDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.ChangeDestinationCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Application Service Class to all Commands:
 *      - Book a DroneBox.
 *      - Route a DroneBox (+ itinary function used for route command) .
 *      - Change the Destination of a DroneBox.
 */
@Service
@Slf4j
public class DroneBoxBookingService {

    private final CommandGateway commandGateway;

    private ExternalDroneBoxRoutingService externalDroneBoxRoutingService;

    public DroneBoxBookingService(CommandGateway commandGateway,ExternalDroneBoxRoutingService externalDroneBoxRoutingService){
        this.commandGateway = commandGateway;
        this.externalDroneBoxRoutingService = externalDroneBoxRoutingService;
    }

    /**
     * Command to Book a DroneBox
     * @param bookDroneBoxCommand
     */
    public String bookDroneBox(BookDroneBoxCommand bookDroneBoxCommand){
        String random = UUID.randomUUID().toString().toUpperCase();
        bookDroneBoxCommand.setBookingId(random.substring(0, random.indexOf("-")));

        commandGateway.send(bookDroneBoxCommand);
        return bookDroneBoxCommand.getBookingId();
    }

    /**
     * Command to Assigns a Route to a DroneBox
     * @param bookingId, routeSpecification
     */
    public void assignRouteToDroneBox(String bookingId, String routeSpecification){
        commandGateway.send(new AssignRouteToDroneBoxCommand(bookingId,
                externalDroneBoxRoutingService.getItinaryForSpecification(routeSpecification)));
    }


    /**
     * Change the Destination of a DroneBox
     * @param changeDestinationCommand
     */
    public void changeDestinationOfDroneBox(ChangeDestinationCommand changeDestinationCommand) {
        commandGateway.send(changeDestinationCommand);
    }

}
