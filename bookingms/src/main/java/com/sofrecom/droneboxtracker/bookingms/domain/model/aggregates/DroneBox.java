package com.sofrecom.droneboxtracker.bookingms.domain.model.aggregates;

import java.lang.invoke.MethodHandles;


import com.sofrecom.droneboxtracker.bookingms.domain.commands.AssignRouteToDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.BookDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.ChangeDestinationCommand;
import com.sofrecom.droneboxtracker.bookingms.domain.events.*;
import com.sofrecom.droneboxtracker.bookingms.domain.model.entities.Location;
import com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AbstractAggregateRoot;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class DroneBox extends AbstractAggregateRoot<DroneBox> {

    private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AggregateIdentifier
    private String bookingId; // Aggregate Identifier

    private BookingAmount bookingAmount; //Booking Amount
    private Location origin; //Origin Location of the DroneBox
    private RouteSpecification routeSpecification; //Route Specification of the DroneBox
    private Itinerary itinerary; //Itinerary Assigned to the DroneBox
    private RoutingStatus routingStatus; //Routing Status of the DroneBox
    private TransportStatus transportStatus; //Transport Status of the DroneBox


   public DroneBox() {
       // Required by Axon Framework
   }

    @CommandHandler
    public DroneBox(BookDroneBoxCommand bookDroneBoxCommand) {

        logger.info("bookDroneBoxCommand: Handling {}", bookDroneBoxCommand);
        if(bookDroneBoxCommand.getBookingAmount() < 0){
            throw new IllegalArgumentException("Booking Amount cannot be negative");
        }

        apply(new DroneBoxBookedEvent(bookDroneBoxCommand.getBookingId(),
                                    bookDroneBoxCommand.getBookingAmount(),
                                    bookDroneBoxCommand.getOriginLocation(),
                                    bookDroneBoxCommand.getOriginLocation()+"-"+bookDroneBoxCommand.getDestLocation()));
    }

    /**
     * Command Handler for Assigning the Route to a DroneBox
     * @param assignRouteToDroneBoxCommand
     */

    @CommandHandler
    public void handle(AssignRouteToDroneBoxCommand assignRouteToDroneBoxCommand) {
        logger.info("assignRouteToDroneBoxCommand: Booking Id {}",assignRouteToDroneBoxCommand.getBookingId());
        routingStatus = RoutingStatus.ROUTED;
        apply( new DroneBoxRoutedEvent(assignRouteToDroneBoxCommand.getBookingId(),
                assignRouteToDroneBoxCommand.getRoutes()));

        registerEvent(new
                DroneBoxRoutedTrackEvent(new DroneBoxRoutedEventData(assignRouteToDroneBoxCommand.getBookingId())));
    }


    /**
     * DroneBox Handler for changing the Destination of a DroneBox
     * @param changeDestinationCommand
     */
    @CommandHandler
    public void handle(ChangeDestinationCommand changeDestinationCommand){
        if(routingStatus.equals(RoutingStatus.ROUTED)){
            throw new IllegalArgumentException("Cannot change destination of a Routed DroneBox");
        }

        apply(new DroneBoxDestinationChangedEvent(changeDestinationCommand.getBookingId(),
                                new RouteSpecification(origin,
                                        new Location(""))));

    }

    /**
     * Event Handler for the DroneBox Booked Event
     * @param droneboxBookedEvent
     */
    @EventSourcingHandler //Annotation indicating that the Aggregate is Event Sourced and is interested in the DroneBox Booked Event raised by the Book DroneBox Command
    public void on(DroneBoxBookedEvent droneboxBookedEvent) {
        logger.info("BOOKED EventSourcing Applying {}", droneboxBookedEvent.getBookingId());
        // State being maintained
        bookingId = droneboxBookedEvent.getBookingId();
        /*bookingAmount = droneboxBookedEvent.getBookingAmount();
        origin = droneboxBookedEvent.getOriginLocation();
        routeSpecification = droneboxBookedEvent.getRouteSpecification();*/
        routingStatus = RoutingStatus.ROUTED;
        transportStatus = TransportStatus.NOT_STARTED;
        logger.info("Routing Status is: "+routingStatus);
    }

    /**
     * Event Handler for the DroneBox Routed Event
     * @param droneboxRoutedEvent
     */
    @EventSourcingHandler //Annotation indicating that the Aggregate is Event Sourced and is interested in the DroneBox Routed Event raised by the Book DroneBox Command
    public void on(DroneBoxRoutedEvent droneboxRoutedEvent) {
        logger.info("ROUTED EventSourcingHandler: Applying for ID= {}", droneboxRoutedEvent.getBookingId());
      //  itinerary = droneboxRoutedEvent.getItinerary();
        //routingStatus = RoutingStatus.ROUTED;
    }

    /**
     * Event Handler for the Change Destination Event
     * @param droneboxDestinationChangedEvent
     */
    @EventSourcingHandler //Annotation indicating that the Aggregate is Event Sourced and is interested in the DroneBox Booked Event raised by the Book DroneBox Command
    public void on(DroneBoxDestinationChangedEvent droneboxDestinationChangedEvent) {
        logger.info("CHANGEDDESTINATION Applying {}", droneboxDestinationChangedEvent);
        routingStatus = RoutingStatus.NOT_ROUTED;
     //   routeSpecification = droneboxDestinationChangedEvent.getNewRouteSpecification();

    }

}
