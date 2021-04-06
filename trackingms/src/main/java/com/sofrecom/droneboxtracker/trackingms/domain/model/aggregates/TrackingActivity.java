package com.sofrecom.droneboxtracker.trackingms.domain.model.aggregates;

import com.sofrecom.droneboxtracker.trackingms.domain.model.commands.AddTrackingEventCommand;
import com.sofrecom.droneboxtracker.trackingms.domain.model.commands.AssignTrackingNumberCommand;
import com.sofrecom.droneboxtracker.trackingms.domain.model.entities.BookingId;
import com.sofrecom.droneboxtracker.trackingms.domain.model.entities.TrackingActivityEvent;
import com.sofrecom.droneboxtracker.trackingms.domain.model.valueobjects.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.UUID;

//@Table(name="tracking_activity")

@Entity
@NamedQueries({
        @NamedQuery(name = "TrackingActivity.findAll",
                query = "Select t from TrackingActivity t"),
        @NamedQuery(name = "TrackingActivity.findByTrackingNumber",
                query = "Select t from TrackingActivity t where t.trackingNumber = :trackingNumber"),
        @NamedQuery(name = "TrackingActivity.findAllTrackingNos",
                query = "Select t.trackingNumber from TrackingActivity t"),
        @NamedQuery(name="TrackingActivity.findByBookingId",
                query = "Select t from TrackingActivity t where t.bookingId = :bookingId")})
@Table(name="tracking_activity")
public class TrackingActivity extends AbstractAggregateRoot<TrackingActivity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private TrackingNumber trackingNumber; // Aggregate Identifier
    @Embedded
    private BookingId bookingId;
    @Embedded
    private TrackingActivityEvent trackingActivityEvent;

    public TrackingActivity(){}

    /**
     * Creates a new Tracking Number
     * @param assignTrackingNumberCommand
     */
    public TrackingActivity(AssignTrackingNumberCommand assignTrackingNumberCommand){
        this.trackingNumber = new TrackingNumber(assignTrackingNumberCommand.getTrackingNumber());
        this.bookingId = new BookingId((assignTrackingNumberCommand.getBookingId()));
        this.trackingActivityEvent = TrackingActivityEvent.EMPTY_ACTIVITY;
    }

    /**
     * Add a tracking event to the Tracking Details
     * @param addTrackingEventCommand
     */
    public void addTrackingEvent(AddTrackingEventCommand addTrackingEventCommand){
        System.out.println("added tracking event : "+addTrackingEventCommand);
/*        TrackingEvent trackingEvent = new TrackingEvent(
                new TrackingVoyageNumber(addTrackingEventCommand.getVoyageNumber()),
                new TrackingLocation(addTrackingEventCommand.getLocation()),
                new TrackingEventType(addTrackingEventCommand.getEventType(),addTrackingEventCommand.getEventTime()));*/

        String voyageNumber = "";
        if ((addTrackingEventCommand.getVoyageNumber() == null) || (addTrackingEventCommand.getVoyageNumber().equals(""))) {
            voyageNumber = "no voyage number";
        }
        else {
            voyageNumber = addTrackingEventCommand.getVoyageNumber();
        }
        this.trackingActivityEvent.setTrackingActivityEvent( "booking id : " + addTrackingEventCommand.getBookingId() + "/" + voyageNumber + "/"+
                        addTrackingEventCommand.getLocation() + " handling : " + addTrackingEventCommand.getEventType() + " at " +
                        addTrackingEventCommand.getEventTime());
                //getTrackingEvents().add(trackingEvent);
    }


    /**
     * Gets next Tracking Identifier
     * @return
     */

    public String nextTrackingNumber() {
        String random = UUID.randomUUID().toString().toUpperCase();
        return random.substring(0, random.indexOf("-"));
    }
    public TrackingNumber getTrackingNumber(){
        return this.trackingNumber;
    }

    public BookingId getBookingId(){
        return this.bookingId;
    }

    public TrackingActivityEvent getTrackingActivityEvents() {
        return this.trackingActivityEvent;
    }





}
