package com.sofrecom.droneboxtracker.handlingms.domain.model.aggregates;


import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.DroneBoxBookingId;
import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.Location;
import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.Type;
import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.VoyageNumber;
import com.sofrecom.droneboxtracker.shareddomain.events.DroneboxHandledEvent;
import com.sofrecom.droneboxtracker.shareddomain.events.DroneboxHandledEventData;
import com.sofrecom.droneboxtracker.shareddomain.events.DroneBoxRoutedEvent;
import com.sofrecom.droneboxtracker.shareddomain.events.DroneBoxRoutedEventData;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;

/**
 * Root Aggregate for the Handling Bounded Context
 */
@Entity
@NamedQuery(name = "HandlingActivity.findByBookingId",
        query = "Select e from HandlingActivity e where e.droneboxBookingId.bookingId = :bookingId")
//@Table(name="handling_activity")
public class HandlingActivity extends AbstractAggregateRoot<HandlingActivity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name="event_type")
    private Type type;
    @Embedded
    private VoyageNumber voyageNumber;
    @Embedded
    private Location location;
    @Temporal(TemporalType.DATE)
    @Column(name = "event_completion_time")
    private Date completionTime;

    @Embedded
    private DroneBoxBookingId droneboxBookingId;

    public HandlingActivity(){}


    /**
     * Constructor for the Handling Activity - With a VoyageNumber
     * @param droneboxBookingId
     * @param completionTime
     * @param type
     * @param location
     * @param voyageNumber
     */
    public HandlingActivity(DroneBoxBookingId droneboxBookingId, Date completionTime,
                        Type type, Location location, VoyageNumber voyageNumber) {

        if (type.prohibitsVoyage()) {
            throw new IllegalArgumentException(
                    "VoyageNumber is not allowed with event type " + type);
        }

        this.voyageNumber = voyageNumber;
        this.completionTime = (Date) completionTime.clone();
        this.type = type;
        this.location = location;
        this.droneboxBookingId = droneboxBookingId;

        DroneboxHandledEvent droneboxHandledEvent =
                new DroneboxHandledEvent(
                    new DroneboxHandledEventData(
                        this.droneboxBookingId.getBookingId(),
                        this.completionTime,
                        this.location.getLocCode(),
                        this.type.toString(),
                        this.voyageNumber.getVoyageNumber()));


        //Add this domain event which needs to be fired when the new dronebox is saved
        addDomainEvent(droneboxHandledEvent);
    }

    /**
     * Constructor for the Handling Activity - Without a VoyageNumber
     * @param droneboxBookingId
     * @param completionTime
     * @param type
     * @param location
     */
    public HandlingActivity(DroneBoxBookingId droneboxBookingId, Date completionTime,
                          Type type, Location location) {

        if (type.requiresVoyage()) {
            throw new IllegalArgumentException(
                    "VoyageNumber is required for event type " + type);
        }

        this.completionTime = (Date) completionTime.clone();
        this.type = type;
        this.location = location;
        this.droneboxBookingId = droneboxBookingId;
        this.voyageNumber = null;

        DroneboxHandledEvent droneboxHandledEvent =
                new DroneboxHandledEvent(
                        new DroneboxHandledEventData(
                                this.droneboxBookingId.getBookingId(),
                                this.completionTime,
                                this.location.getLocCode(),
                                this.type.toString(),
                               ""));


        //Add this domain event which needs to be fired when the new dronebox is saved
        addDomainEvent(droneboxHandledEvent);
    }


    public Type getType() {
        return this.type;
    }

    public VoyageNumber getVoyage() {
        return this.voyageNumber;
    }

    public Date getCompletionTime() {
        return new Date(this.completionTime.getTime());
    }

    public Location getLocation() { return this.location; }

    public DroneBoxBookingId getDroneBoxBookingId() {
        return this.droneboxBookingId;
    }

    /**
     * Method to register the event
     * @param event
     */
    public void addDomainEvent(Object event){
        registerEvent(event);
    }
}


