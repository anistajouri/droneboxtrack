package com.sofrecom.droneboxtracker.shareddomain.events;

import java.util.Date;

/**
 * Event Data for the DroneBox Handled Event
 */
public class DroneboxHandledEventData {
    private String bookingId;
    private String handlingType;
    private Date handlingCompletionTime;
    private String handlingLocation;
    private String voyageNumber;

    public DroneboxHandledEventData(){}

    public DroneboxHandledEventData(
            String bookingId,
            Date handlingCompletionTime,
            String handlingLocation,
            String handlingType,
            String voyageNumber
    ){
        this.bookingId = bookingId;
        this.handlingCompletionTime = handlingCompletionTime;
        this.handlingLocation = handlingLocation;
        this.handlingType = handlingType;
        this.voyageNumber = voyageNumber;
    }

    public String getBookingId(){return this.bookingId;}
    public String getHandlingType(){return this.handlingType;}
    public Date getHandlingCompletionTime(){return this.handlingCompletionTime;}
    public String getHandlingLocation(){return this.handlingLocation;}
    public String getVoyageNumber(){return this.voyageNumber;}

}
